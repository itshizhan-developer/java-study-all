/**
 * Created by leeson8888 on 2019/2/20.
 */
package com.itshizhan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String SayHello(){
		return  "hello spring boot and vue";
	}
}
