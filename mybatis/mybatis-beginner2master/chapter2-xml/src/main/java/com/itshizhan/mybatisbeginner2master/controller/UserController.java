package com.itshizhan.mybatisbeginner2master.controller;

import com.itshizhan.mybatisbeginner2master.bean.SysRole;
import com.itshizhan.mybatisbeginner2master.bean.SysUser;
import com.itshizhan.mybatisbeginner2master.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserMapper userMapper;

	@GetMapping("/getRolesById")
	public List<SysRole> getRolesByUserId(Long id){
		return userMapper.selectRolesByUserId(id);
	}

	@GetMapping("/getUserById")
	public SysUser getUserById(Long id){
		SysUser sysUser = userMapper.selectById(id);
		return  sysUser;

	}

	@GetMapping("/getAllUser")
	public List<SysUser> getAllUser(){
		List<SysUser> userList = userMapper.selectAll();
		return userList;
	}

}
