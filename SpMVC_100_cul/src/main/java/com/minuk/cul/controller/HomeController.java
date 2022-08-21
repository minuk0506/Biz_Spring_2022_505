package com.minuk.cul.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minuk.cul.model.EventVO;
import com.minuk.cul.model.FestivalVO;
import com.minuk.cul.model.MsmArtGlrVO;
import com.minuk.cul.model.RuinsVO;
import com.minuk.cul.model.TourVO;
import com.minuk.cul.service.EventService;
import com.minuk.cul.service.FestivalService;
import com.minuk.cul.service.MsmartglrService;
import com.minuk.cul.service.RuinsService;
import com.minuk.cul.service.TourService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final TourService tourService;
	private final RuinsService ruinsService;
	private final MsmartglrService msmartglrService;
	private final FestivalService festivalService;
	private final EventService eventService;
	
	
	
	public HomeController(TourService tourService, RuinsService ruinsService, MsmartglrService msmartglrService,
			FestivalService festivalService, EventService eventService) {
		this.tourService = tourService;
		this.ruinsService = ruinsService;
		this.msmartglrService = msmartglrService;
		this.festivalService = festivalService;
		this.eventService = eventService;
	}

	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		String tourQueryStr = tourService.tourQueryStr(null);
		tourService.getTourItems(tourQueryStr);
		log.debug("Tour 받은 데이터 {}",tourQueryStr);
		List<TourVO> tourJson = tourService.getTourItems(tourQueryStr);
		model.addAttribute("TOURS", tourJson);

		String ruinsQueryStr = ruinsService.RuinsQueryStr(null);
		ruinsService.getRuinsItems(ruinsQueryStr);
		log.debug("Ruins 받은 데이터 {}",ruinsQueryStr);
		List<RuinsVO> ruinsJson = ruinsService.getRuinsItems(ruinsQueryStr);
		model.addAttribute("RUINS", ruinsJson);
		
		String msmartglrQueryStr = msmartglrService.MsmartglrQueryStr(null);
		msmartglrService.getMsmartglrItems(msmartglrQueryStr);
		log.debug("Msmartglr 받은 데이터 {}",msmartglrQueryStr);
		List<MsmArtGlrVO> Msmartglrjson = msmartglrService.getMsmartglrItems(msmartglrQueryStr);
		model.addAttribute("MSMARTGLRS", Msmartglrjson);
		
		String festivalQueryStr = festivalService.FestivalQueryStr(null);
		festivalService.getFestivalItems(festivalQueryStr);
		log.debug("Festival 받은 데이터 {}",festivalQueryStr);
		List<FestivalVO> FestivalJson = festivalService.getFestivalItems(festivalQueryStr);
		model.addAttribute("FESTIVALS", FestivalJson);
		
		String eventQueryStr = eventService.EventQueryStr(null);
		eventService.getEventItems(eventQueryStr);
		log.debug("Event 받은 데이터 {}",eventQueryStr);
		List<EventVO> EventJson = eventService.getEventItems(eventQueryStr);
		model.addAttribute("EVENTS", EventJson);
		return "home";
	}

}