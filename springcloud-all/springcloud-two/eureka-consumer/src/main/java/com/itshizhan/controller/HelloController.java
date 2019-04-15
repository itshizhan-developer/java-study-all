package com.itshizhan.controller;

import com.itshizhan.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	HelloRemote helloRemote;

	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name) {
		System.out.println("HelloController--/hello"+name);
		return helloRemote.hello(name);
	}
}
