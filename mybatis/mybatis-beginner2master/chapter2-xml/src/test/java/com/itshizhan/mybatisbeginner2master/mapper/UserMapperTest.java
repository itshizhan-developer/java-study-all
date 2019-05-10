package com.itshizhan.mybatisbeginner2master.mapper;


import com.itshizhan.mybatisbeginner2master.bean.SysRole;
import com.itshizhan.mybatisbeginner2master.bean.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	private void log(Object object){
		System.out.println("-------------------result start-----------------------\r\n");
		System.out.println(object);
		System.out.println("\r\n-------------------result end-----------------------");

	}

	@Autowired
	UserMapper userMapper;

	@Test
	public void getUserById(){
		SysUser sysUser = userMapper.selectById(1L);
		log(sysUser);

	}

	@Test
	public void getAllUser(){
		List<SysUser> userList = userMapper.selectAll();
		log(userList);

	}

	@Test
	public void selectRolesByUserId(){
		List<SysRole> sysRoles = userMapper.selectRolesByUserId(1L);
		log(sysRoles);

	}

}
