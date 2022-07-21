package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistence.StudentDao;
import com.callor.score.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{
	
	private StudentDao studentDao;
	public StudentServiceImplV1(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	public List<StudentVO> selectAll() {
		
		return studentDao.selectAll();
	}

	@Override
	public StudentVO findById(String id) {
		return null;
	}

	@Override
	public int insert(StudentVO vo) {
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

}
