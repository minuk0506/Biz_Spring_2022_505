package com.callor.school.service.impl;

import java.util.List;

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

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
