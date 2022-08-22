package com.minuk.cul.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minuk.cul.model.FestivalVO;
import com.minuk.cul.service.FestivalService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/active")
public class FestivalController {
	
	private final FestivalService festivalService;
	
	public FestivalController(FestivalService festivalService) {
		this.festivalService = festivalService;
	}

	@RequestMapping(value={"/festival"}, method=RequestMethod.GET)
	public String home(Model model) {
		String festivalQueryStr = festivalService.FestivalQueryStr(null);
		festivalService.getFestivalItems(festivalQueryStr);
		log.debug("Festival 받은 데이터 {}",festivalQueryStr);
		List<FestivalVO> FestivalJson = festivalService.getFestivalItems(festivalQueryStr);
		model.addAttribute("FESTIVALS", FestivalJson);
		
		return "/active/festival";
	}

}