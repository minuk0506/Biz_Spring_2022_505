package com.schoolverse.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schoolverse.app.model.AcademyVO;
import com.schoolverse.app.model.BelongVO;
import com.schoolverse.app.model.ClassVO;
import com.schoolverse.app.model.ScheduleVO;
import com.schoolverse.app.model.TeacherVO;
import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.service.AcademyService;
import com.schoolverse.app.service.BelongService;
import com.schoolverse.app.service.ClassService;
import com.schoolverse.app.service.ScheduleService;
import com.schoolverse.app.service.TeacherService;

@Controller
public class RegisterController {

	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private AcademyService academyService;
	@Autowired
	private ClassService classService;
	@Autowired
	private BelongService belongService;

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String register(Model model) {
		return null;
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String register(Model model,HttpSession session, AcademyVO acaVO, String[] teacher_name, String[] teacher_info) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		academyService.insert(acaVO);

		BelongVO bVO = BelongVO.builder()
				.aca_code(acaVO.getAca_code())
				.username(userVO.getUsername())
				.build();
		belongService.insert(bVO);
		
		Long aca_teacher = acaVO.getAca_teacher();
		List<Long> teacher_id_list = new ArrayList<>();

		for (int i = 0; i < teacher_name.length; i++) {
			TeacherVO vo = TeacherVO.builder().aca_teacher(aca_teacher).teacher_name(teacher_name[i])
					.teacher_info(teacher_info[i]).build();
			teacherService.insert(vo);
			teacher_id_list.add(vo.getTeacher_id());
		}
		return null;
	}
	
	@RequestMapping(value = "/user/schedule_register", method = RequestMethod.GET)
	public String schedule_register() {
		return null;
	}
	
	@RequestMapping(value = "/user/schedule_register", method = RequestMethod.POST)
	public String schedule_register(Model model,HttpSession session, String class_name, String class_subject,
			String class_fee, String[] sche_day, String[] sche_period) {
		
		
		System.out.println();
		System.out.println();
		System.out.println(class_name);
		System.out.println(class_subject);
		System.out.println(class_fee);
		System.out.println(Arrays.toString(sche_day) );
		System.out.println(Arrays.toString(sche_period) );
		System.out.println();
		System.out.println();
		
		UserVO userVO = (UserVO) session.getAttribute("USER");
		
		long aca_code = belongService.findAcaCodeById(userVO.getUsername());

			ClassVO classVO = ClassVO.builder().aca_code(aca_code).class_name(class_name)
					.class_subject(class_subject).class_fee(class_fee).build();
			classService.insert(classVO);
			// 수업 스케줄 넣기
			
			for (int i = 0; i < sche_day.length; i++) {
				for (int j = 0; j < sche_period.length; j++) {
					if(Integer.parseInt(sche_period[j].split(";")[0]) == i) {
						ScheduleVO scheVO = ScheduleVO.builder()
								.sche_code(classVO.getSche_code())
								.sche_day(sche_day[i])
								.sche_period(sche_period[j].split(";")[1])
								.build();
						scheduleService.insert(scheVO);
					}
				}
			}
		 



			
	
		
		return null;
	}
}
