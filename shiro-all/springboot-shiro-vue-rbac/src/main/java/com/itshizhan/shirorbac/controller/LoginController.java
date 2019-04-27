package com.itshizhan.shirorbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	// 处理/login 务必不能添加 @GetMapping("/")
	@GetMapping()
	public String login(){
		System.out.println("/login");
		return "登录页面";
	}

	@GetMapping("/auth")
	public String loginAuth(){
		return "登录页面处理";
	}

}
