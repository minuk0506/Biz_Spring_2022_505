package com.callor.sec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.sec.model.UserVO;
import com.callor.sec.persistence.UserDao;
import com.callor.sec.service.AdminService;

@Service
public class AdminServiceImplV1 implements AdminService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passEncoder;
	
	@Override
	public int update(UserVO userVO, String admin) {
		
		// admin 정보 가져오기
		UserVO adminVO = userDao.findById(admin);
		String password = userVO.getPassword();
		
		// admin 비번이 틀리면 되돌아가기
		if(passEncoder.matches(password, adminVO.getPassword()) == false) {
			return -1;
		}
		
		UserVO getUserVO = userDao.findById(userVO.getUsername());
		userVO.setPassword(getUserVO.getPassword());
		
		int ret = userDao.update(userVO);
		
		return ret;
	}

}
