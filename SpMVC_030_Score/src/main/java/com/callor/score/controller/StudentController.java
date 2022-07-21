package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {

	private StudentService stuSerV1;
	
	public StudentController(StudentService stuSerV1) {
		this.stuSerV1 = stuSerV1;
	}
	
	// JSON type 으로 return
	@ResponseBody
	@RequestMapping(value={"","/"}, method=RequestMethod.GET)
	// 학생리스트를 return 하기 위해 return type List<StudentVO>
	public List<StudentVO> home() {
		List<StudentVO> stuVO = stuSerV1.selectAll();
		return stuVO;
	}
	
}
