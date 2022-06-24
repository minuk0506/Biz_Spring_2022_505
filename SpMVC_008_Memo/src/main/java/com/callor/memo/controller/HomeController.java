package com.callor.memo.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

@Controller
public class HomeController {
	
	private final MemoService memoService;
	public HomeController(MemoService memoService) {
		this.memoService = memoService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<MemoVO> memoList = memoService.selectAll();
		model.addAttribute("memoList",memoList);
		
		return "home";
	}
	
	@RequestMapping(value = "/detail",method = RequestMethod.POST)
	public String home(Model model) {
		
		return "/memo/detail";
	}
	
	
}
