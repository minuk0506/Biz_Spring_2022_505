package com.schoolverse.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolverse.app.model.AcademyVO;
import com.schoolverse.app.model.BasketVO;
import com.schoolverse.app.model.ClassVO;
import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.service.AcademyService;
import com.schoolverse.app.service.BasketService;
import com.schoolverse.app.service.ClassService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/search")
public class SearchController {
	
	@Autowired
	private AcademyService acaService;
	@Autowired
	private BasketService basketService;
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String search(Model model, HttpSession session) {
		List<AcademyVO> acaList = acaService.selectAll();
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
		model.addAttribute("ACA", acaList);
		return null;
	}
	@RequestMapping(value = "/basket_add", method = RequestMethod.GET)
	public String basket_add(Model model,String c_code, HttpSession session) {
		
		UserVO userVO = (UserVO)session.getAttribute("USER");
		
		if(basketService.findByClassAndId(c_code, userVO.getUsername()) != null) {
			return "redirect:/search?result=USED";
		}
		
		BasketVO basketVO = BasketVO.builder().c_code(c_code).u_id(userVO.getUsername()).build();
		
		basketService.insert(basketVO);
		
		return "redirect:/search";
	}

	@RequestMapping(value = "/basket_delete", method = RequestMethod.GET)
	public String basket_delete(Model model,String class_code, HttpSession session) {
		
		UserVO userVO = (UserVO)session.getAttribute("USER");

		basketService.delete(class_code, userVO.getUsername());
		
		return "redirect:/search";
	}
	
	@ResponseBody
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basket(Model model,String c_code, HttpSession session) {
		
		UserVO userVO = (UserVO)session.getAttribute("USER");
		
		List<String> classes = basketService.findClassListById(userVO.getUsername());
		List<AcademyVO> academyList = new ArrayList<>();
		for(String c : classes) {
			academyList.add(acaService.findById(c));
		}
		
		ObjectMapper mapper = new ObjectMapper();
		 
		String vo = "";
		try {
			mapper.getFactory().configure(JsonWriteFeature.ESCAPE_NON_ASCII.mappedFeature(), true);
			vo = mapper.writeValueAsString(academyList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping(value = "/aca_info", method = RequestMethod.GET)
	public String aca_info(Model model,String aca_code) {
		List<Object> list = new ArrayList<>();
		AcademyVO acaVO = acaService.findById(aca_code);
		list.add(acaVO);

		List<ClassVO> classList = classService.findByAcaCode(aca_code);
		list.add(classList);
		ObjectMapper mapper = new ObjectMapper();
		 
		String vo = "";
		try {
			mapper.getFactory().configure(JsonWriteFeature.ESCAPE_NON_ASCII.mappedFeature(), true);
			vo = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	
}