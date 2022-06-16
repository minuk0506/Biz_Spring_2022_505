package com.schoolverse.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolverse.app.model.ClassVO;
import com.schoolverse.app.model.ScheduleVO;
import com.schoolverse.app.persistence.ClassDao;
import com.schoolverse.app.service.ClassService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ClassServiceImpl implements ClassService{
	
	@Autowired
	ClassDao dao;

	@Override
	public List<ClassVO> selectAll() {
		return null;
	}

	@Override
	public ClassVO findById(String id) {
		return dao.findById(id);
	}

	@Override
	public int insert(ClassVO vo) {
		dao.insert(vo);
		return 0;
	}

	@Override
	public int update(ClassVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public List<ScheduleVO> findScheduleByClassCode(long c_code) {
		return dao.findScheduleByClassCode(c_code);
	}

	@Override
	public List<ClassVO> findByAcaCode(long aca_code) {
		return dao.findByAcaCode(aca_code);
	}
	


}
