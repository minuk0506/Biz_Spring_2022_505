package com.schoolverse.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schoolverse.app.model.HomeVO;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(HomeVO homeVO) {
		
		
		
		return "home";
	}
	

}
