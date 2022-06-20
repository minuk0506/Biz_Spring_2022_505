package com.callor.images.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.model.BBsVO;
import com.callor.images.persistance.BBsDao;

public interface BBsService extends BBsDao{

	public String insertBbsAndFile(BBsVO bbsVO, MultipartFile file);
	public String insertBbsAndFiles(BBsVO bbsVO, MultipartHttpServletRequest file);
	
}
