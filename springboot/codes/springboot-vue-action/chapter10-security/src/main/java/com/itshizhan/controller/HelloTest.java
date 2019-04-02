package com.itshizhan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {

	@GetMapping("/")
	public String sayHello(){
		return "hello spring security";
	}

	@GetMapping("/admin/hello")
	public String admin() {
		return "hello admin!";
	}

	@GetMapping("/admin/db/hello")
	public String admin2() {
		return "/admin/db/hello";
	}

	@GetMapping("/user/hello")
	public String user() {
		return "hello user!";
	}

	@GetMapping("/db/hello")
	public String dba() {
		return "hello dba!";
	}

}
