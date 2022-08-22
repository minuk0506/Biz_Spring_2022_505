package com.minuk.cul.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minuk.cul.model.RuinsVO;
import com.minuk.cul.service.RuinsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/travel")
public class RuinsController {
	
	private final RuinsService ruinsService;
	public RuinsController(RuinsService ruinsService) {
		this.ruinsService = ruinsService;
	}

	@RequestMapping(value={"/ruins"}, method=RequestMethod.GET)
	public String home(Model model) {

		String ruinsQueryStr = ruinsService.RuinsQueryStr(null);
		ruinsService.getRuinsItems(ruinsQueryStr);
		log.debug("Ruins 받은 데이터 {}",ruinsQueryStr);
		List<RuinsVO> ruinsJson = ruinsService.getRuinsItems(ruinsQueryStr);
		model.addAttribute("RUINS", ruinsJson);
		
		return "/travel/ruins";
	}

}