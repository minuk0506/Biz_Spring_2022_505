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
import com.schoolverse.app.model.ClassVO;
import com.schoolverse.app.model.ScheduleVO;
import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.service.AcademyService;
import com.schoolverse.app.service.BasketService;
import com.schoolverse.app.service.ClassService;
import com.schoolverse.app.service.ScheduleService;

@Controller
@RequestMapping(value = "/schedule")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private BasketService basketService;
	@Autowired
	private ClassService classService;
	@Autowired
	private AcademyService acaService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String schedule(Model model, HttpSession session) {

		UserVO userVO = (UserVO) session.getAttribute("USER");
		// 수업찾기
		if (userVO == null) {
			return "redirect:/user/login";
		}
		List<String> classes = basketService.findClassListById(userVO.getUsername());
		List<ClassVO> classList = new ArrayList<>();
		List<List<ScheduleVO>> scheduleVO = new ArrayList<>();

		for (String c : classes) {
			classList.add(classService.findById(c));
			
			scheduleVO.add(scheduleService.findScheduleByClassCode(c));
		}


		// 스케줄찾기
		List<String> scheList = new ArrayList<>();
		for (List<ScheduleVO> list : scheduleVO) {
			String scheStr = "";
			for(ScheduleVO vo:list) {
				scheStr = scheStr + vo.getSche_day() + "_" + vo.getSche_period() + ",";
			}
			scheList.add(scheStr);				
		}
		
		System.out.println();
		System.out.println();
		System.out.println(scheList);
		System.out.println();
		System.out.println();
		
		model.addAttribute("CLASS", classList);
		model.addAttribute("SCHE", scheList);

		return null;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/aca_map_schedule", method = RequestMethod.GET)
	public String aca_map_schedule(Model model, HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		
		List<String> cCodeList = basketService.findClassListById(userVO.getUsername());
		List<ClassVO> classList = new ArrayList<>();
		for(String cCode : cCodeList) {
			classList.add(classService.findById(cCode));
		}
		
		List<AcademyVO> acaList = new ArrayList<>();
		for(ClassVO c : classList) {
		acaList.add(acaService.findByAcaCode(c.getAca_code()));
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		 
		String json = "";
		try {
			mapper.getFactory().configure(JsonWriteFeature.ESCAPE_NON_ASCII.mappedFeature(), true);
			json = mapper.writeValueAsString(acaList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
}
