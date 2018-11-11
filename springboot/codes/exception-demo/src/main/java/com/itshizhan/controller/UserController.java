/**
 * Created by leeson8888 on 2018/11/1.
 */
package com.itshizhan.controller;

import com.itshizhan.exceptions.CustomException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(getClass());


	@RequestMapping("/getUser")
	public String getUser(){

		logger.debug("getUser：输出日志了");
		//int i = 1/0;
		return "getUser ok";
	}


	@RequestMapping("/getAllUser")
	public String getAllUser() throws CustomException {

		throw new CustomException("你没有权限获取全部用户");

	}


}
