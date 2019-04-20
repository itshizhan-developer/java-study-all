package com.itshizhan;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class BaseTest {
	protected void login(String configFile, String username, String password) {

		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		IniRealm iniRealm = new IniRealm(configFile);
		securityManager.setRealm(iniRealm);

		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
			System.out.println("认证成功");
		}catch (AuthenticationException e){
			System.out.println("认证失败");
		}

	}


}
