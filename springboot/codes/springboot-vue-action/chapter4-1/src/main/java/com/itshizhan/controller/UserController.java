/**
 * Created by leeson8888 on 2019/2/27.
 */
package com.itshizhan.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

	//@GetMapping(value = "/user",produces = {"application/json;charset=UTF-8" })
	@GetMapping(value = "/user")
	public Map<String, Object> getUserInfo(Model model){
		Map<String, Object> map1 = new HashMap<>();
		Map<String, Object> map = model.asMap();
		System.out.println(map); //{userInfo={gender=男, username=罗贯中}}
		map1 = (Map<String, Object>) map.get("userInfo");
		return  map1;

	}
}
