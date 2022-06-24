package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;

public interface MemoService extends MemoDao{

	public String upFile(MultipartFile file) throws Exception;
	public String insertFile(MemoVO memoVO, MultipartFile file);
}
