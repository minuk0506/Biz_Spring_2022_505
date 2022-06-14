package com.schoolverse.app.service;

import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.persistence.UserDao;

public interface UserService extends UserDao{

	public UserVO login(UserVO userVO);
	public int join(UserVO userVO);
	
}
