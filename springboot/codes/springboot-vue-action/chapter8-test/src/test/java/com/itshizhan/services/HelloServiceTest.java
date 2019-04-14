package com.itshizhan.services;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

	@Autowired
	HelloService helloService;

	@Test
	public void sayHello() {
		String ret = helloService.sayHello("itshizhan");
		Assert.assertThat(ret, Matchers.is("Hello itshizhan !"));
	}
}