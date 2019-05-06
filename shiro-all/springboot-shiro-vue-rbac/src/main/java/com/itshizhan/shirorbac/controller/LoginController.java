package com.itshizhan.shirorbac.controller;

import com.alibaba.fastjson.JSONObject;
import com.itshizhan.shirorbac.service.LoginService;
import com.itshizhan.shirorbac.utils.CommonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {




//	@PostMapping("/auth")
//	public Map<String,Object> loginAuth(String name,String password){
//
//		Subject subject = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
//		Map<String,Object> map = new HashMap<>();
//		try {
//			subject.login(token);
//			//登录成功
//			map.put("code",1);
//			map.put("msg","登录成功");
//
//
//
//		} catch (UnknownAccountException e) {
//			//登录成功
//			map.put("code",20002);
//			map.put("msg","登录失败，用户名或密码错误");
//
//		}
//		return map;
//		//return "登录页面处理";
//	}

	@Autowired
	private LoginService loginService;

@PostMapping("/auth")
public JSONObject loginAuth(@RequestBody JSONObject requestJson){

	CommonUtil.hasAllRequired(requestJson, "username,password");
	return loginService.authLogin(requestJson);

}

	@GetMapping("/getUserInfo")
	public Map<String,Object> getUserInfo(){
		Map<String,Object> map = new HashMap<>();
		map.put("code",1);
		map.put("msg","获取用户信息成功");
		return map;
	}

}
