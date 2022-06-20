package com.schoolverse.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolverse.app.model.BelongVO;
import com.schoolverse.app.persistence.BelongDao;
import com.schoolverse.app.service.BelongService;

@Service
public class BelongServiceImpl implements BelongService{
	@Autowired
	BelongDao dao;
	
	@Override
	public List<BelongVO> selectAll() {
		return null;
	}

	@Override
	public BelongVO findById(String id) {
		return dao.findById(id);
	}

	@Override
	public int insert(BelongVO vo) {
		dao.insert(vo);
		return 0;
	}

	@Override
	public int update(BelongVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public long findAcaCodeById(String username) {
		return dao.findAcaCodeById(username);
	}

}
