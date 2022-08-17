package com.minuk.cul.service;

import java.util.List;

import com.minuk.cul.model.TourVO;

public interface TourService {
	public String queryString(String search);
	public List<TourVO> getTourItems(String queryString);
}
