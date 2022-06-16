package com.schoolverse.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolverse.app.model.ScheduleVO;
import com.schoolverse.app.persistence.ScheduleDao;
import com.schoolverse.app.service.ScheduleService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	ScheduleDao dao;
	
	@Override
	public List<ScheduleVO> selectAll() {
		return dao.selectAll();
	}


	@Override
	public ScheduleVO findById(String id) {
		return dao.findById(id);
	}

	@Override
	public int insert(ScheduleVO vo) {
		dao.insert(vo);
		return 0;
	}

	@Override
	public int update(ScheduleVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public List<ScheduleVO> findScheduleByClassCode(String class_code) {
		return dao.findScheduleByClassCode(class_code);
	}





}
