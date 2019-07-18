package com.itshizhan.hessianclient.controller;

import com.itshizhan.hessianclient.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping("/test")
	public String test() {
		return helloWorldService.sayHello("Spring boot with Hessian.");
	}
}
