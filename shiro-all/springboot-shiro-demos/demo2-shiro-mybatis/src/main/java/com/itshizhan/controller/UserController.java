package com.itshizhan.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

	@GetMapping("/")
	@ResponseBody
	public String sayHello(){
		return "hello shiro";
	}

	@GetMapping("/index")
	public String index(){
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/add")
	public String add(){
		return "/user/add";
	}

	@RequestMapping("/update")
	public String update(){
		return "/user/update";
	}

	@RequestMapping("/noAuth")
	public String noAuth(){
		return "noAuth";
	}

	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, @RequestParam String password, Model model) {
		System.out.println("name:"+name+"--password:"+password);

		//1.获取Subject
		Subject subject = SecurityUtils.getSubject();
		//2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);

		//3.执行登录方法
		try {
			subject.login(token);

			//登录成功跳转到首页
			return "redirect:/index";
		} catch (AuthenticationException e)  {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			model.addAttribute("msg", "用户名或密码错误");
			return "login";
		}

	}

}
