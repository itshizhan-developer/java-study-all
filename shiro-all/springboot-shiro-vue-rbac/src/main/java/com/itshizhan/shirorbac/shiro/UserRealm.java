package com.itshizhan.shirorbac.shiro;

import com.alibaba.fastjson.JSONObject;
import com.itshizhan.shirorbac.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm  extends AuthorizingRealm {

	@Autowired
	private  LoginService loginService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 假设数据库用户名和密码
		// String name = "admin";
		// String password = "123456";

		// 获取用户提交的token:包含用户名和密码
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		String loginName = uToken.getUsername();

		// 获取密码可以使用uToken.getCredentials()，Object 类型;也可以使用 uToken.getPassword()，字节数组 byte[] 类型
		String loginPassword = new String(uToken.getPassword());

		// 根据登录token，查询数据用户，并进行比对
		JSONObject user = loginService.getUser(loginName,loginPassword);

		//1.判断用户名
		if(user == null){
			return  null; //shiro底层会抛出UnKnowAccountException, 用户名不存在
		}

		//2.判断密码， 注意第一个参数为user，否则授权时 subject.getPrincipal()返回的类型可能不匹配
		return new SimpleAuthenticationInfo(
						user.getString("username"),
						user.getString("password"),"");


	}
}
