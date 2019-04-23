package com.itshizhan.shiro;

import com.itshizhan.domain.User;
import com.itshizhan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;
	/**
	 * 执行授权逻辑
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo 授权------------");
		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 为当前访问用户添加权限
		//info.addStringPermission("user:add");
		//得到当前用户
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		User dbUser = userService.findById(user.getId());
		info.addStringPermission(dbUser.getPerms());
		return info;
	}

	/**
	 * 执行认证逻辑
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("doGetAuthorizationInfo 认证------------");
		// 假设数据库用户名和密码
//		String name = "admin";
//		String password = "123456";
		// 获取用户提交的token
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;


		User user = userService.findByName(uToken.getUsername());

		//1.判断用户名
		if(user==null){
			return  null; //shiro底层会抛出UnKnowAccountException, 用户名不存在
		}

		//2.判断密码， 注意第一个参数为user，否则授权时 subject.getPrincipal()返回的类型可能不匹配
		return new SimpleAuthenticationInfo(user,user.getPassword(),"");

	}

}
