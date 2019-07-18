package com.itshizhan.hessianserver.service;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceImpl implements HelloWorldService {
	@Override
	public String sayHello(String name) {
		return "Hello," + name;
	}
}
