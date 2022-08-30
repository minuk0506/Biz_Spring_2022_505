package com.callor.exp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.exp.service.UserService;

import lombok.extern.slf4j.Slf4j;

/*
 * sts 도구를 사용하여 project 를 시작했을때
 * 아무런 설정을 하지 않은 상태에서
 * 프로젝트의 home 화면을 열면
 * base-package.HomeController 클래스에 선언된
 * home() method 가 Request를 수신하여 사용자에게 Response 를 수행한다
 * 라는 것을 알 수 있다
 */

@Slf4j
@Controller
public class HomeController {
	
	private final UserService userService;
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.debug("home 콘트롤러 home method");
		return "home";
	}
	/*
	 * 누군가(Web Browser) POST : "http://localhost:8080/exp/" 로
	 * 요청을 보냈을때 만약 username, password 라는 변수에 데이터를 담아서
	 * 보내면 String username, String password 변수에 받겠다라는 선언
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(String username, String password) {
		log.debug("POST Home username = {}, password = {}",username, password);
		return "home";
	}
	
}
