package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.UserVO;

import lombok.extern.slf4j.Slf4j;

/*
 * 프로젝트 시작할때
 * No quailfying bean of type '..' 오류가 발생하는 경우
 * UserService 인터페이스를 사용하여 Bean 주입받겠다 라고 Controller 에 선언을 했다
 * 		1. 생성자를 통해서 주입받기
 * 		2. Autowired 를 사용하여 setter 를 통해서 주입받기
 * 
 * 어디에도 해당하는 bean 을 생성, 선언한 곳이 없을때 발생하는 오류
 * 
 * Dao 가 없다고 나오면 mybatis-context, servlet-context 에 mybatis-spring:scan, component-scan 이 안되어 있는 경우가 많다
 */
@Slf4j
@Service(QualifierConfig.SERVICE.USER_V2)
public class UserServiceImplV2 extends UserServiceImplV1 {
	
	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Override
	public int join(UserVO userVO) {
		
		List<UserVO> users = userDao.selectAll();
		if(users == null || users.size() < 1) {
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("GUEST");
		}
		
		// password 를 암호화 하자
		String planPassword = userVO.getPassword();
		String encPassword = passwordEncoder.encode(planPassword);
	
		// 암호화된 password 를 다시 VO 에 setting
		userVO.setPassword(encPassword);
		
		// user 정보를 insert
		userDao.insert(userVO);
		
		return 0;
	}
	@Override
	public UserVO login(UserVO userVO) {
		
		UserVO loginUsers = userDao.findById(userVO.getUsername());
		
		String encPassword = loginUsers.getPassword();
		String planPassword = userVO.getPassword();
		// (평문, 암호화된 문자열)
		if(passwordEncoder.matches(planPassword, encPassword)) {
			return loginUsers;
		}
		
		return null;
	}


}
