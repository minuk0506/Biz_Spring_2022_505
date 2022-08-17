package com.minuk.cul.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minuk.cul.model.TourVO;
import com.minuk.cul.service.TourService;

@Controller
@RequestMapping(value="/cul")
public class ApiController {
	
private final TourService tourService;
	
	public ApiController(TourService tourService) {
		this.tourService = tourService;
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.POST)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/tour", method = RequestMethod.GET)
	public List<TourVO> Tour() {
		
		String queryString = tourService.queryString(null);
		List<TourVO> tours = tourService.getTourItems(queryString);
		
		return tours;
	}
}
