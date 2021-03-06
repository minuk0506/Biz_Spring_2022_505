package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

/*
 * Cors 오류가 발생하지 않도록 서버에서 설정하기
 * React 의 fetch 요청에 대하여 CORS 문제를 건너뛰도록 설정하기
 */
@Slf4j
@CrossOrigin({ "http://localhost:3000", "http://127.0.0.1" })
@Controller
@RequestMapping(value = "/student")
public class StudentController {

	private StudentService stuSerV1;

	public StudentController(StudentService stuSerV1) {
		this.stuSerV1 = stuSerV1;
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<StudentVO> stList = stuSerV1.selectAll();
		model.addAttribute("STUDENTS", stList);
		return "student/list";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("st_num") String st_num, Model model) {
		StudentVO stvo = stuSerV1.findById(st_num);
		model.addAttribute("STUDENT", stvo);
		return "student/detail";
	}

	@RequestMapping(value = "/detail/{st_num}/update", method = RequestMethod.GET)
	public String update(@PathVariable("st_num") String st_num, Model model) {
		StudentVO stvo = stuSerV1.findById(st_num);
		model.addAttribute("STUDENT", stvo);
		return "student/update";
	}

	/*
	 * student update?st_num=S001 로 input form 에서
	 * 저장 버튼을 클릭했을때
	 * form 에 action 이 설정되어 있지 않기 때문에 
	 * POST 전송도 같은 주소로 요청이 된다
	 * 이때 주소창에 st_num=S001 이라는 변수가 설정되어 있기 때문에
	 * 
	 * form 에 st_num 항목을 설정하지 않아도 StudentVO 의 st_num 변수에
	 * 학번 값이 들어간다
	 */
	@RequestMapping(value = "/detail/{st_num}/update", method = RequestMethod.POST)
	public String update(@PathVariable("st_num") String st_num, Model model, StudentVO stnum) {
		StudentVO stvo = stuSerV1.findById(st_num);
		model.addAttribute("STUDENT", stvo);
		stuSerV1.update(stnum);
		return "redirect:/";
	}

	// JSON type 으로 return
	@ResponseBody
	@RequestMapping(value = { "/json" }, method = RequestMethod.GET)
	// 학생리스트를 return 하기 위해 return type List<StudentVO>
	public List<StudentVO> home() {
		List<StudentVO> stList = stuSerV1.selectAll();
		return stList;
	}

	@ResponseBody
	@RequestMapping(value = "/{st_num}/delete")
	public String delete(@PathVariable("st_num") String st_num) {
		int ret = stuSerV1.delete(st_num);
		if (ret > 0) {
			return "OK";
		} else {
			return "FAIL";
		}

	}
}
