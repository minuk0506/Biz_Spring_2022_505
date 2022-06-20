package com.schoolverse.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolverse.app.model.BelongVO;
import com.schoolverse.app.model.UserVO;
import com.schoolverse.app.service.BelongService;
import com.schoolverse.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		return null;
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		userService.join(userVO);
		
		return "redirect:/user/login";
	}


	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model) {
		return null;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserVO userVO, Model model, HttpSession session) {
		
		UserVO loginUser = userService.findById(userVO.getUsername());
		
		if(loginUser == null) {
			model.addAttribute("error","USERNAME_FAIL");
			return "redirect:/user/login";
		}
		loginUser = userService.login(userVO);
		if(loginUser == null) {
			model.addAttribute("error","PASSWORD_FAIL");
			return "redirect:/user/login";
		}

		session.setAttribute("USER", loginUser);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		return "redirect:/";
	}
	

	@ResponseBody
	@RequestMapping(value="/idcheck/{username}",method=RequestMethod.GET)
	public String idcheck(@PathVariable("username") String username) {
		
		UserVO userVO = userService.findById(username);
		if(userVO == null) {
			return "OK";
		}
		return "FAIL";
	}
	
	@ResponseBody
	@RequestMapping(value="/emailcheck",method=RequestMethod.GET)
	public String emailcheck(String email) {
		
		UserVO userVO = userService.findByEmail(email);
		if(userVO == null) {
			return "OK";
		}
		return "FAIL";
	}

	
	
}
