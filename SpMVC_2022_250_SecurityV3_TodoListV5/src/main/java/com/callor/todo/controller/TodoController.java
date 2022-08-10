package com.callor.todo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

@Controller
@RequestMapping(value="/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String home(Principal principal, Model model) {
		
		// Spring Security Project 에서 로그인한 사용자의
		// username 을 get 하기
		String username = principal.getName();
		
		// 만약 혹시, 로그인된 사용자 정보를 알 수 없으면
		// 로그인 화면으로 redirect
		if(username == null) {
			return "redirect:/user/login?error=LOGIN_NEED";
		}
		
		// 사용자의 username 이 정상이면
		// 데이터 SELECT 하기
		List<TodoVO> todoList = todoService.findByUsername(username);
		
		model.addAttribute("TODOS",todoList);
		model.addAttribute("LAYOUT", "TODO_LIST");
		
		return "home";
	}
	
	public String insert(String todo) {
		// todoService.insert() 에게
		// todoVO 에 데이터를 담아서 보내야 한다
		TodoVO todoVO = TodoVO.builder()
				.todo(todo)
				.build();
		todoService.insert(todoVO);
		return "redirect:/todo";
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.POST)
	public String insert(Principal principal, TodoVO todoVO) {
		
		String username = principal.getName();
		if(username ==null) {
			return "redirect:/user/login?error=LOGIN_NEED";
		}
		
		todoVO.setUsername(username);
		todoService.insert(todoVO);
		return "redirect:/todo";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String seq, Model model) {
		
		Long l_seq = 0L;
		try {
			l_seq = Long.valueOf(seq);
		} catch (Exception e) {
			
		}
		TodoVO todoVO = todoService.findById(l_seq);
		model.addAttribute("TODO",todoVO);
		model.addAttribute("LAYOUT","TODO_LIST");
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(TodoVO todoVO, Model model) {
		
		todoService.update(todoVO);
		
		return "redirect:/todo";
	}
	
}
