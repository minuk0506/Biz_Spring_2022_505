package com.schoolverse.app.persistence;

import java.util.List;

import com.schoolverse.app.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String> {
	
	public List<UserVO> findByName(String name);
	public List<UserVO> findByNickName(String nickName);
	
	public UserVO findByEmail(String email);
	
	
}
