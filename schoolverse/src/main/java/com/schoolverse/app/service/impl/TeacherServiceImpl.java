package com.schoolverse.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolverse.app.model.TeacherVO;
import com.schoolverse.app.persistence.TeacherDao;
import com.schoolverse.app.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	TeacherDao dao;
	
	@Override
	public List<TeacherVO> selectAll() {
		return null;
	}

	@Override
	public TeacherVO findById(String id) {
		return null;
	}

	@Override
	public int insert(TeacherVO vo) {
		dao.insert(vo);
		return 0;
	}

	@Override
	public int update(TeacherVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public List<TeacherVO> findByAcaTeacher(long aca_teacher) {
		return dao.findByAcaTeacher(aca_teacher);
	}

}



