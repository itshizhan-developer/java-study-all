package com.itshizhan.shirorbac.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm  extends AuthorizingRealm {
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 假设数据库用户名和密码
		 String name = "admin";
		 String password = "123456";

		// 获取用户提交的token
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;


		//1.判断用户名
		if(!uToken.getUsername().equals(name)){
			return  null; //shiro底层会抛出UnKnowAccountException, 用户名不存在
		}

		//2.判断密码， 注意第一个参数为user，否则授权时 subject.getPrincipal()返回的类型可能不匹配
		return new SimpleAuthenticationInfo("",password,"");


	}
}
