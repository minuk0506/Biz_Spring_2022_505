package com.callor.naver.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.callor.naver.model.NewsVO;
import com.callor.naver.service.impl.NewsServiceImplV1;

@Controller
@RequestMapping(value="/news")
public class NewsController {
	
	
	private final NewsServiceImplV1 newsService;
	
	public NewsController(NewsServiceImplV1 newsService) {
		this.newsService = newsService;
	}
	
	@RequestMapping(value={"/",""})
	public String home() {
		return "/news/list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		List<NewsVO> newsList = newsService.selectAll();
		model.addAttribute("NEWS",newsList);
		model.addAttribute("LAYOUT","NEWS");
		return null;
	}
}
