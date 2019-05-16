package com.itshizhan.chapter4.controller;


import com.itshizhan.chapter4.bean.SysUser;
import com.itshizhan.chapter4.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

	@PostMapping("/selectByIdList1")
	public List<SysUser> selectByIdList1(@RequestParam(value = "idList",required = false) List<Long> idList){
//		List<Long> idList = new ArrayList();
//		idList.add(1L);
//		idList.add(2L);
//		idList.add(1040L);
		ArrayList<Long> arrayList = new ArrayList<>();
		arrayList.add(1038L);
		arrayList.add(1040L);
		return userMapper.selectByIdList1(arrayList);
	}

	@PostMapping("/selectByIdList2")
	public List<SysUser> selectByIdList2(@RequestParam(value = "idList",required = false) Long [] idList){
		return userMapper.selectByIdList2(idList);
	}

	@PostMapping("/selectByIdList3")
	public List<SysUser> selectByIdList3(@RequestParam() List<Long> idList1,
																			 @RequestParam() List<Long> idList2){
		return userMapper.selectByIdList3(idList1,idList2);
	}

	// 批量插入用户
	@GetMapping("/insertUserByList")
	public int insertUserByList(){
		List<SysUser> userList = new ArrayList<>();
		SysUser user1 = new SysUser();
		user1.setUserName("test1_insert");
		user1.setUserEmail("test1@163.com");
		user1.setUserPassword("123456");
		user1.setUserInfo("test1_insert_userInfo");

		SysUser user2 = new SysUser();
		user2.setUserName("test2_insert");
		user2.setUserEmail("test2@163.com");
		user2.setUserPassword("123456");
		user2.setUserInfo("test2_insert_userInfo");

		userList.add(user1);
		userList.add(user2);
		return userMapper.insertUserByList(userList);
	}


}
