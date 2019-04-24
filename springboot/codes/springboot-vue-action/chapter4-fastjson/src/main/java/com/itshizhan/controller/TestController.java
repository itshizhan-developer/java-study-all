package com.itshizhan.controller;

import com.itshizhan.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String toHello() {
		return "hello fastJson";
	}

	@GetMapping("/testJson")
	public User testJson() {
		User user = new User(1,"jack",29,"123456");
		return user;
	}
}
