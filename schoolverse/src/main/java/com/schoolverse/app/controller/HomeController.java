package com.schoolverse.app.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.schoolverse.app.service.AcademyService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {

	@Autowired
	private AcademyService acaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/aca_map_search", method = RequestMethod.GET)
	public String aca_map_search(Model model, String aca_region, String aca_age, String aca_subject) {

		List<AcademyVO> acaList = acaService.findByAcaRegion(aca_region);
		List<AcademyVO> resultList = new ArrayList<>();
		for(AcademyVO vo:acaList) {
			if(vo.getAca_subject().equals(aca_subject) && vo.getAca_age().equals(aca_age)) {
				resultList.add(vo);
			}
		}		
		
		model.addAttribute("SEARCH", resultList);
		
		ObjectMapper mapper = new ObjectMapper();
		 
		String json = "";
		try {
			mapper.getFactory().configure(JsonWriteFeature.ESCAPE_NON_ASCII.mappedFeature(), true);
			json = mapper.writeValueAsString(resultList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
}
