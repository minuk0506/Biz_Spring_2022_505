package com.callor.school.service.impl;

import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

/*
 * UserServiceImplV1 클래스를 Component(스프링에선 bean) 로 등록하기
 */
@Service
public class UserServiceImplV1 implements UserService{

	@Override
	public UserVO login(UserVO userVO) {
		
		String username = userVO.getUsername();
		String password = userVO.getPassword();
		
		if(username.equals("minuk")
			&& password.equals("12341234")){
			userVO.setName("이민욱");
			userVO.setRole("ADMIN");
			userVO.setEmail("minuk0506@naver.com");
		} else {
			userVO = null;
		}
		
		return userVO;
	}

	@Override
	public UserVO join(UserVO userVO) {
		return null;
	}
}
