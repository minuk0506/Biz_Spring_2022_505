package com.minuk.cul.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minuk.cul.model.TourVO;
import com.minuk.cul.service.TourService;

@Controller
@RequestMapping(value="/cul")
public class ApiController {
	
private final TourService tourService;
	
	public ApiController(TourService tourService) {
		this.tourService = tourService;
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home() {
		String queryString = tourService.queryString(null);
		tourService.getTourItems(queryString);
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/tour", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<TourVO> Tour() {
		
		String queryString = tourService.queryString(null);
		List<TourVO> tours = tourService.getTourItems(queryString);
		
		return tours;
	}
}
