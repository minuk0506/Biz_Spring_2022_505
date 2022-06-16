package com.schoolverse.app.service;

import com.schoolverse.app.model.BasketVO;
import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.persistence.BasketDao;

public interface BasketService extends BasketDao{

	int insert(BasketVO basketVO, UserVO userVO);

}
