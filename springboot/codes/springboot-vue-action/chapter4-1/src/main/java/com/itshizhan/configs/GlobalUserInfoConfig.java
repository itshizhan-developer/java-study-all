/**
 * Created by leeson8888 on 2019/2/27.
 */
package com.itshizhan.configs;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalUserInfoConfig {

	@ModelAttribute(value = "userInfo")
	public Map<String,String> userInfo(){
		HashMap<String,String> map = new HashMap<>();
		map.put("username","罗贯中");
		map.put("gender","男");
		return  map;
	}

	@InitBinder("a")
	public void initBook(WebDataBinder binder){
		binder.setFieldDefaultPrefix("a.");
	}


	@InitBinder("b")
	public void initAuthor(WebDataBinder binder){
		binder.setFieldDefaultPrefix("b.");
	}

}
