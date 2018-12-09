/**
 * Created by leeson8888 on 2018/11/29.
 */
package com.itshizhan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/")
	public String Index(){
		return "hello spring";
	}
}
