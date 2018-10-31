/**
 * Created by leeson8888 on 2018/11/1.
 */
package com.itshizhan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/getUser")
	public String getUser(){

		int i = 1/0;
		return "getUser ok";
	}
}
