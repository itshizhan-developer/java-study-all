package com.itshizhan.shirorbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
	@GetMapping("/noAuth")
	public Map<String,Object> index() {
		Map<String,Object> map = new HashMap<>();
		map.put("code",1);
		map.put("msg","测试：当前访问不需要权限");
		return map;
	}
}
