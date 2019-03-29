package com.itshizhan.configs;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyFirstQuartzJob {
	public void  sayHello(){
		System.out.println("MyFirstQuartzJob sayHello:" + new Date());
	}
}
