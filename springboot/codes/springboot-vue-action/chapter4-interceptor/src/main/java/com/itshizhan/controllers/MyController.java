package com.itshizhan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/hello2")
	public String hello2() {
		return "hello2";
	}
}
