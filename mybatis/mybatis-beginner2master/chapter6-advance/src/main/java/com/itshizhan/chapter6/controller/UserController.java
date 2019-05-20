package com.itshizhan.chapter6.controller;

import com.itshizhan.chapter6.mapper.UserMapper;
import com.itshizhan.common.bean.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserMapper userMapper;

	@GetMapping("selectUserAndRoleById")
	public SysUser selectUserAndRoleById(){

		return userMapper.selectUserAndRoleById(1058L);
	}

	@GetMapping("selectUserAndRoleById1")
	public SysUser selectUserAndRoleById1(){

		return userMapper.selectUserAndRoleById1(1058L);
	}

	@GetMapping("selectUserAndRoleById2")
	public SysUser selectUserAndRoleById2(){

		return userMapper.selectUserAndRoleById2(1058L);
	}

	@GetMapping("selectUserAndRoleById3")
	public SysUser selectUserAndRoleById3(){

		return userMapper.selectUserAndRoleById3(1058L);
	}


}
