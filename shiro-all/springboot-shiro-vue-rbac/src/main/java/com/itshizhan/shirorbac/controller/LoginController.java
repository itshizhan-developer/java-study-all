package com.itshizhan.shirorbac.controller;

import com.itshizhan.shirorbac.constants.ResultEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {


	@PostMapping("/auth")
	public Map<String,Object> loginAuth(String name,String password){

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		Map<String,Object> map = new HashMap<>();
		try {
			subject.login(token);
			//登录成功
			map.put("code",1);
			map.put("msg","登录成功");



		} catch (UnknownAccountException e) {
			//登录成功
			map.put("code",20002);
			map.put("msg","登录失败，用户名或密码错误");

		}
		return map;
		//return "登录页面处理";
	}

	@GetMapping("/getUserInfo")
	public Map<String,Object> getUserInfo(){
		Map<String,Object> map = new HashMap<>();
		map.put("code",1);
		map.put("msg","获取用户信息成功");
		return map;
	}

}
