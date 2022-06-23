package com.callor.ems.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileUpServiceImplV1 implements FileUpService{

	// 파일을 넣을 폴더 경로
	@Autowired
	private String upPath;
	
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// upPath = "c:/file/upload"; 문자열로 해도되지만 servlet-context에 놓는게 오류 발생시 조치 쉬움
		
		// 받은 파일이 존재하는지
		if(file == null) {
			return null;
		}
		
		// 받은 파일을 넣을 폴더가 존재하는지
		File dir = new File(upPath);
		log.debug(upPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		// 파일의 이름을 fileName 변수에 담는다
		String fileName = file.getOriginalFilename();
		
		// 랜덤UUID를 strUUID에 담는다
		String strUUID = UUID.randomUUID().toString();
		
		// 파일이름 앞에 UUID를 붙여 fileName에 담는다
		fileName = String.format("%s-%s", strUUID,fileName);
		
		// fileUpLoad에 파일을 넣을 경로와 파일정보를 담는다
		File fileUpLoad = new File(upPath, fileName);
		
		// 파일을 저장한다. (throws로 Exception 처리를 해준다)
		file.transferTo(fileUpLoad);
		
		// 파일의 정보를 돌려준다
		return fileName;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest mFile) throws Exception {
		
		// 업로드된 파일들을 리스트에 담는다
		List<MultipartFile> fileList = mFile.getFiles("mFile");
		
		// for() 를 이용하여 fileList 에 담긴 파일들을 fileUp method에 보내 수행시킨다
		for(MultipartFile files : fileList) {
			String fileName = files.getOriginalFilename();
			
			// add throws 로 Exception 처리를 해준다
			String uuName = this.fileUp(files);
		}
		
		return null;
	}

}
