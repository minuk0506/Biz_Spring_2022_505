package com.schoolverse.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model) {

		return null;
	}
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public String schedule(Model model) {

		return null;
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public String pay(Model model) {

		return null;
	}
}
