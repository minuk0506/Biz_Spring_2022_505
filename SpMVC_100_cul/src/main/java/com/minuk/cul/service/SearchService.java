package com.minuk.cul.service;

import java.util.List;

import org.springframework.ui.Model;

import com.minuk.cul.model.SearchVO;
import com.minuk.cul.persistance.SearchDao;

public interface SearchService extends SearchDao{

	public void searchAndPage(Model model,SearchVO searchPage);
	
}
