/**
 * Created by leeson8888 on 2018/10/31.
 */
package com.itshizhan.controller;

import com.itshizhan.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
public class IndexController {

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e, HttpServletRequest request) {
		String requestURL = request.getRequestURL().toString();
		System.out.println(requestURL);
		e.printStackTrace();
		return new Result(500,"服务器出错了");
	}

	@RequestMapping("/index")
	public String Index(){
		int j = 2/0;
		return "index";
	}
}
