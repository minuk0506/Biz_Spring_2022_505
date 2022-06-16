package com.schoolverse.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolverse.app.model.AcademyVO;
import com.schoolverse.app.persistence.AcademyDao;
import com.schoolverse.app.service.AcademyService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class AcademyServiceImpl implements AcademyService{
	
	@Autowired
	AcademyDao dao;
	
	@Override
	public List<AcademyVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public AcademyVO findById(String id) {
		return dao.findById(id);
	}

	@Override
	public int insert(AcademyVO vo) {
		dao.insert(vo);
		return 0;
	}

	@Override
	public int update(AcademyVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public List<AcademyVO> findByAcaRegion(String aca_region) {
		return dao.findByAcaRegion(aca_region);
	}

	@Override
	public List<AcademyVO> findByAcaSubject(String aca_subject) {
		return dao.findByAcaSubject(aca_subject);
	}

	@Override
	public List<AcademyVO> findByAcaAge(String aca_age) {
		return dao.findByAcaAge(aca_age);
	}

	@Override
	public AcademyVO findByAcaCode(long aca_code) {
		return dao.findByAcaCode(aca_code);
	}


}
