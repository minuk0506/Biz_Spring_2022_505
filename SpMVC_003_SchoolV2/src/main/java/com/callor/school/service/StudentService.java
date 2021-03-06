package com.callor.school.service;

import java.util.List;

import com.callor.school.domain.StudentVO;

public interface StudentService {
	
	/*
	 * CRUD method 의 prototype 선언
	 * C (Create, insert) : 새로운 데이터 추가
	 * R (Read, selectAll, findByStNum) : 데이터 읽기
	 * U (Update, update) : 기존 데이터 변경
	 * D (Delete, delete) : 기존 데이터 중 삭제 	 (한번에 한개씩)
	 */
	public List<StudentVO> selectAll();
	public StudentVO findByStNum(String stNum);
	
	public Integer input(StudentVO stVO);
	public Integer list2(StudentVO stVO);
	public Integer delete(String stNum); 
	
	public List<StudentVO> findByStTel(String stTel);
	public List<StudentVO> findByStName(String stName);
	public List<StudentVO> findByStAddr(String stAddr);
	
}
