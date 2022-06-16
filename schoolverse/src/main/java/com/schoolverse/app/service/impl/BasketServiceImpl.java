package com.schoolverse.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolverse.app.model.BasketVO;
import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.persistence.BasketDao;
import com.schoolverse.app.service.BasketService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class BasketServiceImpl implements BasketService{
	@Autowired
	BasketDao dao;
	
	@Override
	public List<BasketVO> selectAll() {
		return null;
	}

	@Override
	public BasketVO findById(String id) {
		return dao.findById(id);
	}

	@Override
	public int insert(BasketVO vo) {
		dao.insert(vo);
		return 0;
	}
	@Override
	public int insert(BasketVO basketVO, UserVO userVO) {
		
		return 0;
	}

	@Override
	public int update(BasketVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public List<BasketVO> findByClass(String c_code) {
		return null;
	}

	@Override
	public List<String> selectAcademyByClassCode(String c_code) {
		return dao.selectAcademyByClassCode(c_code);
	}

	@Override
	public List<String> findClassListById(String u_id) {
		return dao.findClassListById(u_id);
	}

	@Override
	public int delete(String c_code, String u_id) {
		dao.delete(c_code, u_id);
		return 0;
	}



	@Override
	public String findByClassAndId(long c_code, String u_id) {
		return dao.findByClassAndId(c_code, u_id);
	}


}
