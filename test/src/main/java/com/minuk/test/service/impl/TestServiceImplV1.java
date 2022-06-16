package com.minuk.test.service.impl;

import org.springframework.stereotype.Service;

import com.minuk.test.persistance.TestDao;
import com.minuk.test.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestServiceImplV1 implements TestService{
	
	private final TestDao testDao;
	public TestServiceImplV1(TestDao testDao) {
		this.testDao = testDao;
	}
}
