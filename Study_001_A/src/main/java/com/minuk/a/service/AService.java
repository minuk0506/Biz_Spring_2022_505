package com.minuk.a.service;

import java.util.List;

import com.minuk.a.model.AVO;

public interface AService {
	
	public String AQueryStr(String queryStr);
	public List<AVO> getAItems(String queryStr);
}
