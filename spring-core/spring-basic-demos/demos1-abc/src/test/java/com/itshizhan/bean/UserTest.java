package com.itshizhan.bean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserTest {

	ApplicationContext ac;

	@Before
	public void createAc(){
		ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
	}

	@Test
	public void userBean(){
		// 自行通过new 创建对象
		//User user = new User(1,"jack","666666");
		//System.out.println(user);
	}


	@Test
	public void userBean1(){

		User user = ac.getBean(User.class);
		user.setUid(1);
		user.setUname("jack");
		user.setPassword("666666");
		System.out.println(user);


	}

	@Test
	public void userBean2(){

	}

	@Test
	public void userBean3(){
		User user = ac.getBean(User.class);
	}

	@Test
	public void userBean4(){
		User user = ac.getBean(User.class);
		User user2 = ac.getBean(User.class);
	}

	@Test
	public void userBean5(){


	}

	@Test
	public void userBean6(){
		User user = ac.getBean(User.class);
		System.out.println(user);

	}


	@Test
	public void userBean7(){
		User user = ac.getBean(User.class);
		System.out.println(user);

	}


}