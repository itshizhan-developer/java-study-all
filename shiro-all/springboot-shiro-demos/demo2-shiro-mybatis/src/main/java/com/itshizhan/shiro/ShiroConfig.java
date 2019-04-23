package com.itshizhan.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


	/**
	 * 自定义Realm
	 * 配置类 必须配置 Realm（或定义了 ini 文件），否则启动报错
	 * @return Realm
	 */
	@Bean("userRealm")
	public UserRealm realm(){
		return new UserRealm();
	}

	/**
	 * 创建ShiroFilterFactoryBean
	 * @return ShiroFilterFactoryBean
	 */

  @Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean  shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 全局设置securityManager安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		shiroFilterFactoryBean.setLoginUrl("/login"); // 设置登录页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth"); // 设置未授权页面

		//创建认证过滤器Map
		Map<String, String> filterMap = new LinkedHashMap();

		filterMap.put("/login","anon");   //登录页面不需要认证
		filterMap.put("/doLogin","anon"); //登录controller不需要认证
		//filterMap.put("/index","anon");   //首页暂时不需要认证

		//注意：当前授权拦截后，shiro会自动跳转到未授权页面
		filterMap.put("/add", "perms[user:add]");
		filterMap.put("/update", "perms[user:update]");

		filterMap.put("/**","authc"); 		//其余所有页面必须认证才可访问





		//设置认证过滤器Map
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}


	/**
	 *  创建DefaultWebSecurityManager
	 * @return DefaultWebSecurityManager
	 */
	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//管理Reaml
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	//配置ShiroDialect，用于thymeleaf和shiro标签配合使用
	@Bean
	public ShiroDialect shiroDialect(){
		return  new ShiroDialect();
	}

}
