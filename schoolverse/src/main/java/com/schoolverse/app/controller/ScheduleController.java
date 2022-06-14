package com.schoolverse.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schoolverse.app.model.ClassVO;
import com.schoolverse.app.model.ScheduleVO;
import com.schoolverse.app.model.UserVO;
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
}
