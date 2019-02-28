/**
 * Created by leeson8888 on 2019/2/28.
 */
package com.itshizhan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello world";
	}
}
