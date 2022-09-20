package com.minuk.a.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minuk.a.service.AService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private AService aService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		String AQueryStr = aService.AQueryStr(null);
		aService.getAItems(AQueryStr);
		
		return "home";
	}
	
}
