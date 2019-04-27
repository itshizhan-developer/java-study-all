package com.itshizhan.shirorbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public String index() {
		return "hello springboot shiro vue";
	}
}
