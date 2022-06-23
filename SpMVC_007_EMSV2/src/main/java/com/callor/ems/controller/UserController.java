package com.callor.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;
import com.callor.ems.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V2)
	private SendMailService xMail;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserVO userVO, Model model) {
		
		model.addAttribute("userVO",userVO);
		return null;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("userVO") UserVO userVO) {
		
		userService.join(userVO);
		
		return "user/join_email";
	}
	
	// PathVarriable 방식의 데이터 전송
	// ~~~/user/aa/email_ok/bb
	// ~~~/user/1/email_ok/33
	// ~~~/user/가/email_ok/나
	// ~~~/user/우리나라/email_ok/대한민국
	// 과 같이 패턴이 일치하는 요청을 모두 수용하는 method
	@RequestMapping(value="/{aa}/email_ok/{bb}")
	public String ok(@PathVariable("aa") String aa, @PathVariable("bb") String bb) {
		return "user/join_email";
	}
	
	// queryString 방식의 데이터 전송
	// ?email과 매개변수가 같아야함
	// ~~~/user/email?email=aaa
	// ~~~/user/email?email=가
	// ~~~/user/email?email=111
	@RequestMapping(value="/email")
	public String ok(String email) {
		return "user/join_email";
	}
	
	@RequestMapping(value="/email_ok")
	public String email_ok() {
		return "user/join_email";
	}
	
	// :.* 을 안하면 naver.com 같은 형식일때 .com 이 짤림
	@RequestMapping(value="/email_ok/{email:.*}")
	public String email_ok(@PathVariable("email") String email, @ModelAttribute("userVO") UserVO userVO) {
		
		UserVO emailUserVO = userService.findById(email);
		if(emailUserVO == null) {
			return "redirect:/user/join?error=error";
		} 
		
		userVO.setUsername(null);
		userVO.setEmail(emailUserVO.getEmail());
		userVO.setPassword(null);
		
		log.debug(email);
		return "user/join_next";
	}
	
	@ModelAttribute("userVO")
	private UserVO userVO() {
		return new UserVO();
	}
	
}
