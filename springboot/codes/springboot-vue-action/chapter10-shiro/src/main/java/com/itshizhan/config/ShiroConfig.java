package com.itshizhan.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	@Bean
	public Realm realm(){
		TextConfigurationRealm realm = new TextConfigurationRealm();
		realm.setUserDefinitions("itshizhan=123,user\n admin=123,admin");
		realm.setRoleDefinitions("admin=read,writer\n user=read");
		return realm;
	}

	@Bean
	public ShiroFilterChainDefinition filterChainDefinition(){
		DefaultShiroFilterChainDefinition filterChainDefinition = new DefaultShiroFilterChainDefinition();
		filterChainDefinition.addPathDefinition("/login","anon");
		filterChainDefinition.addPathDefinition("/doLogin","anon");
		filterChainDefinition.addPathDefinition("/logout","logout");
		filterChainDefinition.addPathDefinition("/**","authc");

		return  filterChainDefinition;
	}

	@Bean
	public ShiroDialect shiroDialect(){
		return new ShiroDialect();
	}
}
