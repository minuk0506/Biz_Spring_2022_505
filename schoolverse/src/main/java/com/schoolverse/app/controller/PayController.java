package com.schoolverse.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schoolverse.app.model.ClassVO;
import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.service.AcademyService;
import com.schoolverse.app.service.BasketService;
import com.schoolverse.app.service.ClassService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/pay")
public class PayController {
	
	@Autowired
	private AcademyService acaService;
	@Autowired
	private BasketService basketService;
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String pay(Model model, HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("USER");
		if(userVO == null) {
			return "redirect:/user/login";
		}
		
		List<String> classes = basketService.findClassListById(userVO.getUsername());
		List<ClassVO> classList = new ArrayList<>();
		
		for(String c : classes) {
			classList.add(classService.findById(c));
		}
		
		model.addAttribute("CLASS", classList);
		return null;
	}
	
}
