package com.schoolverse.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.persistence.UserDao;
import com.schoolverse.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int join(UserVO userVO) {
		
		List<UserVO> users = dao.selectAll();
		
		// password 를 암호화 하자
		String planPassword =  userVO.getPassword();
		String encPassword = passwordEncoder.encode(planPassword);
		
		// 암호화된 password 를 다시 VO 에 setting
		userVO.setPassword(encPassword);

		// user 정보를 insert
		dao.insert(userVO);
		
		return 0;
	}
	
	@Override
	public UserVO login(UserVO userVO) {
		UserVO loginUser = dao.findById(userVO.getUsername());
		String encPassword = loginUser.getPassword();
		String planPassword = userVO.getPassword();
		
				// (평문, 암호화된문자열)
		if(passwordEncoder.matches(planPassword, encPassword)) {
			return loginUser;
		}
		return null;
	}

	@Override
	public List<UserVO> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<UserVO> findByNickName(String nickName) {
		return dao.findByNickName(nickName);
	}

	@Override
	public UserVO findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public List<UserVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public UserVO findById(String id) {
		return dao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		dao.insert(vo);
		return 0;
	}

	@Override
	public int update(UserVO vo) {
		dao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		dao.delete(id);
		return 0;
	}


	

}



