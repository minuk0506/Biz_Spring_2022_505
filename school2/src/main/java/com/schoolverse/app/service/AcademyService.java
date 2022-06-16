package com.schoolverse.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.schoolverse.app.model.AcademyVO;
import com.schoolverse.app.persistence.AcademyDao;

public interface AcademyService extends AcademyDao{
	public String insertRegisterAndFile(AcademyVO acaVO, MultipartFile file);

}
