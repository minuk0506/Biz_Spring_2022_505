package com.minuk.cul.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minuk.cul.model.TourVO;
import com.minuk.cul.service.TourService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final TourService tourService;
//	private final SubwayeventService subwayeventService;
	
	public HomeController(TourService tourService/*,SubwayeventService subwayeventService*/) {
		this.tourService = tourService;
//		this.subwayeventService = subwayeventService;
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		String tourQueryStr = tourService.tourQueryStr(null);
		tourService.getTourItems(tourQueryStr);
		log.debug("Tour 받은 데이터 {}",tourQueryStr);
		List<TourVO> json = tourService.getTourItems(tourQueryStr);
		model.addAttribute("DATAS", json);
		
//		String SubwayeventQueryStr = subwayeventService.SubwayeventQueryStr(null);
//		List<SubwayEventVO> subwayjson = subwayeventService.getSubwayeventItems(SubwayeventQueryStr);
//		log.debug("지하철 공연 받은 데이터 {}",subwayjson);
		return "home";
	}

}