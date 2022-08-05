package com.callor.todo.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/users")
public class UserController {

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		return null;
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join() {
		return null;
	}
		
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug(userVO.toString());
		log.debug("정보" + userVO);
		log.debug("정보 {}",userVO);
		log.debug("정보 {} {}",userVO,userVO);
		return null;
	}
	
	@RequestMapping(value = "/mypage", method=RequestMethod.GET)
	public String mypage(@AuthenticationPrincipal UserVO userVO ) {
		
		
		return null;
	}
}