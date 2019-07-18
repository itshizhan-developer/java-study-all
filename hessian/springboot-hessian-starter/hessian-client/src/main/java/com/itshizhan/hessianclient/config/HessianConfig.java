package com.itshizhan.hessianclient.config;

import com.itshizhan.hessianclient.service.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class HessianConfig {

	@Bean
	public HessianProxyFactoryBean helloClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://localhost:9111/HelloWorldService");
		factory.setServiceInterface(HelloWorldService.class);
		return factory;
	}

}
