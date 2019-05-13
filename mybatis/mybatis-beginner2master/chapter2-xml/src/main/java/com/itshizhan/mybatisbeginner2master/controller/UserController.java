package com.itshizhan.mybatisbeginner2master.controller;

import com.itshizhan.mybatisbeginner2master.bean.SysRole;
import com.itshizhan.mybatisbeginner2master.bean.SysRoleExtend;
import com.itshizhan.mybatisbeginner2master.bean.SysUser;
import com.itshizhan.mybatisbeginner2master.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

	@GetMapping("/selectUsersAndRolesByUserId")
	public List<SysRoleExtend> selectUsersAndRolesByUserId(Long id){
		return userMapper.selectUsersAndRolesByUserId(id);
	}

	@GetMapping("/adduser")
	public SysUser insertUser(){
		SysUser user = new SysUser();
		user.setUserName("test1");
		user.setUserPassword("123456");
		user.setUserEmail("itshizhan@163.com");
		user.setUserInfo("test user info");
		//正常情况下应该读入一张图片存到 byte 数纽中
		user.setHeadImg(new byte[] {1, 2, 3});
		user.setCreateTime(new Date());


		int i = userMapper.insertUser(user);
		if(i>0){
			return user;
		}else{
			return new SysUser();
		}

	}

	@GetMapping("/adduser1")
	public SysUser insertUser1(){
		SysUser user = new SysUser();
		user.setUserName("test1");
		user.setUserPassword("1234567");
		user.setUserEmail("itshizhan@163.com");
		user.setUserInfo("test user info");
		//正常情况下应该读入一张图片存到 byte 数纽中
		user.setHeadImg(new byte[] {1, 2, 3});
		user.setCreateTime(new Date());

		int i = userMapper.insertUserAndGetId(user);
		if(i>0){
			return user;
		}else{
			return new SysUser();
		}

	}

	@GetMapping("/adduser2")
	public SysUser insertUser2(){
		SysUser user = new SysUser();
		user.setUserName("test2");
		user.setUserPassword("12345678");
		user.setUserEmail("itshizhan@163.com");
		user.setUserInfo("test user info");
		//正常情况下应该读入一张图片存到 byte 数纽中
		user.setHeadImg(new byte[] {1, 2, 3});
		user.setCreateTime(new Date());

		int i = userMapper.insertUserAndSelectKey(user);
		if(i>0){
			return user;
		}else{
			return new SysUser();
		}

	}

	@GetMapping("/updateById")
	public String updateById(Long id){
		SysUser user  = userMapper.selectById(id);
		if(user!=null){
			//修改用户名
			user.setUserName("test1_updateById");
			int i = userMapper.updateById(user);
			if(i>0){
				return "修改成功";
			}else{
				return "修改失败";
			}
		}else{
			return "没有查询到需要修改的用户";
		}


	}

	@GetMapping("/deleteById")
	public String deleteById(Long id){
		int i  = userMapper.deleteById(id);
		if(i>0){
			return "删除成功";
		}else{
			return "删除失败";
		}

	}



}
