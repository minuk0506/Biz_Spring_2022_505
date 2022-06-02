package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/news")
public class NewsController {

	@RequestMapping(value={"/",""})
	public String home() {
		return "/books/news";
	}
	
	@RequestMapping(value="/list")
	public String list() {
		return null;
	}
}
