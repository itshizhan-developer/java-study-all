/**
 * Created by leeson8888 on 2018/10/31.
 */
package com.itshizhan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/index")
	public String Index(){
		int j = 1/0;
		return "index";
	}
}
