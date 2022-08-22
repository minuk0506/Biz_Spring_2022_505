package com.minuk.cul.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minuk.cul.model.EventVO;
import com.minuk.cul.service.EventService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/active")
public class EventController {
	
	private final EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@RequestMapping(value={"/event"}, method=RequestMethod.GET)
	public String home(Model model) {
		String eventQueryStr = eventService.EventQueryStr(null);
		eventService.getEventItems(eventQueryStr);
		log.debug("Event 받은 데이터 {}",eventQueryStr);
		List<EventVO> EventJson = eventService.getEventItems(eventQueryStr);
		model.addAttribute("EVENTS", EventJson);
		return "/active/event";
	}

}