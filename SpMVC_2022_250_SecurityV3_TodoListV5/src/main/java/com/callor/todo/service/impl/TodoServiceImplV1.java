package com.callor.todo.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service
public class TodoServiceImplV1 implements TodoService{
	
	@Autowired
	private TodoDao todoDao;
	
	// username 사용자의 todoList Dao 로부터 SELECT 하여
	// 즉시 return
	@Override
	public List<TodoVO> findByUsername(String username) {
		// TODO Auto-generated method stub
		return todoDao.findByUsername(username);
	}

	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		return todoDao.selectAll();
	}

	@Override
	public TodoVO findById(Long id) {
		// TODO Auto-generated method stub
		return todoDao.findById(id);
	}

	@Override
	public int insert(TodoVO vo) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeForm = new SimpleDateFormat("HH:mm:SS");
		
		vo.setDate(dateForm.format(date));
		vo.setTime(timeForm.format(date));
		
		return todoDao.insert(vo);
	}

	@Override
	public int update(TodoVO vo) {
		return todoDao.update(vo);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create_todo_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int todoComp(String seq) {
		
		long seque = 0L;
		try {
			seque = Long.valueOf(seq);
		} catch (Exception e) {
			return -1;
		}
		
		TodoVO todoVO = todoDao.findById(seque);
		if(todoVO == null) {
			return -1;
		}
		
		String compdate = todoVO.getCompDate();
		if(compdate == null || compdate.isEmpty()) {
			
			// Java 1.8 이상에서 사용하는 새로운 날짜, 시간 클래스
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:SS");
		
			todoVO.setCompDate(dateTime.format(dateFormat));
			todoVO.setCompTime(dateTime.format(timeFormat));
		} else {
			todoVO.setCompDate("");
			todoVO.setCompTime("");
		}
		
		/*
		 * VO의 변수가 boolean type 일 경우
		 * set method 는 일반적인 setter method pattern 을 따르는데
		 * get method 는 is변수명() 형태의 pattern 으로 변경된다
		 */
		todoVO.setComplete(!todoVO.isComplete());
		int ret = todoDao.update(todoVO);
		return ret;
	}

}
