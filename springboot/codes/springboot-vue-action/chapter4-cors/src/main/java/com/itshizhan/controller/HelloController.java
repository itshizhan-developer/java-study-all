package com.itshizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HelloController {

//	@GetMapping("/")
//	public String sayHello() {
//		int a = 1/0;
//		return "hello springboot with cors";
//	}
	@GetMapping("/index")
	public String index(){
		return "index";
	}
}
