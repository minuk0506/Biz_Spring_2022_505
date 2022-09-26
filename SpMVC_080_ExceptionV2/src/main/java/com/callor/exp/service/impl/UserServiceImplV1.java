package com.callor.exp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.exp.dao.UserDao;
import com.callor.exp.model.UserVO;
import com.callor.exp.service.UserService;

/*
 * Annotation 을 부착하여 Bean 으로 생성 요청
 * @Controller, @Service
 * @Component @Repository @Config
 * 
 * 이 Annotation 은 이름만 다를뿐 하는 일이 거의 같다
 * @Component 는 모든 Annotation 의 parent 이고
 * 특별하게 붙일 항목이 없으면 사용하는데
 * 일부에서는 @Component 를 사용하면 Bean 을 생성하는데
 * 비용이 많이 소요된다고 한다
 */
@Service
public class UserServiceImplV1 implements UserService{

	/*
	 * Project 가 시작된후
	 * userServiceimplV1 : ...circular reference? 문제가 생겼을때
	 * 
	 * 현시점에서 UserDao가 bean 으로 생성되지 않은 상태
	 * (mybatis-context.xml 을 만들지 않았기 때문에
	 * 어디에서 UserDao 를 Bean 으로 생성하는 코드가 없기 때문에
	 * 
	 * 이 상황이 되면 Spring UserDao 를 상속받은 UserService 를 찾고
	 * UserService 를 impl 한 userServiceImplV1 을 Inject 하려고 시도한다
	 * 그런데 문제는 
	 * userServiceImplV1에서 userServiceImplV1 을 Inject(주입) 받으려는
	 * 상황이 발생한다
	 * 
	 * 그래서 무한 반복 순환 코드가 실행되다가 메모리 Full 이 발생한다
	 * stack OverFlower 메시지가 나타나기도 한다
	 */
	private final UserDao userDao;
	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}
		
	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(UserVO userVO) {
		userDao.insert(userVO);
		return 0;
	}

	@Override
	public int update(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 주석 받아오기
	@Override
	public void create_user_table() {
		// TODO Auto-generated method stub
		
	}
	/*
	 * UserDao.create_user_table() method 를
	 * 호출하여 table 을 생성하는 자동 실행 method
	 */
	@Bean
	public void create_table() {
		userDao.create_user_table();
	}
}
