package com.itshizhan.chapter4.controller;


import com.itshizhan.chapter4.bean.SysUser;
import com.itshizhan.chapter4.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserMapper userMapper;

	@PostMapping("/selectUserWithIf")
	public List<SysUser> selectUserWithIf(String userName,String userEmail){
		SysUser user = new SysUser();
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		return userMapper.selectUserWithIf(user);
	}

	@PostMapping("/updateByIdSelective")
	public int updateByIdSelective(SysUser user){
		return userMapper.updateByIdSelective(user);
	}

	@PostMapping("/insertUserSelective")
	public Long insertUserSelective(SysUser user){
		userMapper.insertUserSelective(user);
		return user.getId();
	}
	@PostMapping("/selectByIdOrUserName")
	public SysUser selectByIdOrUserName(SysUser user){
		return userMapper.selectByIdOrUserName(user);
	}

}
