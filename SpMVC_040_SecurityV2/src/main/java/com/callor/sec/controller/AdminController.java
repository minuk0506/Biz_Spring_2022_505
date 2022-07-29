package com.callor.sec.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.sec.model.UserVO;
import com.callor.sec.service.AdminService;
import com.callor.sec.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private UserService userSer;
	
	@Autowired
	private AdminService adminSer;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String adminPage(UserVO userVO, Model model) {
		model.addAttribute("LAYOUT","ADMIN_PAGE");
		List<UserVO> userList = userSer.selectAll();
		model.addAttribute("USERLIST", userList);
		return "home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String adminUpdate(String username, String error, Model model) {
		UserVO userVO = userSer.findById(username);
		model.addAttribute("error",error);
		model.addAttribute("LAYOUT","ADMIN_UPDATE");
		model.addAttribute("USER", userVO);
		return "home";
	}

	/*
	 * Spring security 에서 로그인이 성공하면 Principal 이라는 클래스를
	 * 사용할 수 있다
	 * principal.getName() 를 실행하면 로그인한 사용자의 username 을
	 * 추출할 수 있다
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String userUpdate(UserVO userVO, Principal principal, Model model) {
		
		String admin = principal.getName();
		log.debug("PR 이름 {}", admin);
		int ret = adminSer.update(userVO,admin);
		if(ret < 0) {
			return String.format("redirect:/admin/update?username=%s&error=ADMIN_PASS",userVO.getUsername());
		}
		return "redirect:/admin";
	}
}
