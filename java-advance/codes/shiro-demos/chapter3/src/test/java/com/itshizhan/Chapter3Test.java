package com.itshizhan;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Chapter3Test extends BaseTest{



	@Test
	public void RoleTest(){
		login("classpath:shiro-role.ini", "zhang", "123");
		//判断拥有角色：role1
		Subject subject =  SecurityUtils.getSubject();
		Assert.assertTrue(subject.hasRole("role1"));
		Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
		//Assert.assertTrue(subject.hasRole("role3"));
	}

	@Test
	public void permissionTest(){
		login("classpath:shiro-permission.ini", "zhang", "123");
		Subject subject =  SecurityUtils.getSubject();
		//判断拥有权限:user:create
		Assert.assertTrue(subject.isPermitted("user:create"));
		//判断拥有权限:user:update and user:delete
		Assert.assertTrue(subject.isPermittedAll("user:update", "user:delete"));
		//判断没有权限:user:view
		Assert.assertFalse(subject.isPermitted("user:view"));

	}

	@Test
	public void base64Test(){
		String str = "hello";
		String base64Encoded = Base64.encodeToString(str.getBytes());
		System.out.println(String.format("base64Encoded: %s",base64Encoded));
		String str2 = Base64.decodeToString(base64Encoded);
		System.out.println(String.format("str2: %s",str2));
		Assert.assertEquals(str, str2);
	}
	@Test
	public void hexTest(){
		String str = "hello";
		String hexEncoded = Hex.encodeToString(str.getBytes());
		System.out.println(String.format("hexEncoded: %s",hexEncoded));
		String str2 = new String(Hex.decode(hexEncoded.getBytes()));
		System.out.println(String.format("str2: %s",str2));
		Assert.assertEquals(str, str2);
	}
	@Test
	public void md5HashTest(){
		String pwd = "123456";
		String salt = "admin";
		String md5 = new Md5Hash(pwd, salt).toString();
		String md51 = new Md5Hash(pwd, salt,1024).toString();
		System.out.println(String.format("pwd md5: %s",md5));
	}
}
