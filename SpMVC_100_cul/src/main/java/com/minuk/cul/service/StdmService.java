package com.minuk.cul.service;

import java.util.List;

import com.minuk.cul.model.StdmVO;

public interface StdmService {
	
	public String StdmQueryStr(String search);
	public List<StdmVO> getStdmItems(String queryString);
	
}
