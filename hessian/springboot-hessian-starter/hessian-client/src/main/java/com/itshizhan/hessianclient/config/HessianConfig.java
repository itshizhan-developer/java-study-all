package com.itshizhan.hessianclient.config;


import com.itshizhan.hessianclient.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class HessianConfig {

	@Autowired
	HelloWorldService helloWorldService;

	@Bean
	public HessianProxyFactoryBean helloClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		//该接口的路径，需要和Server中注册的bean名称一致
		factory.setServiceUrl("http://localhost:9111/HelloWorldService");
		factory.setServiceInterface(HelloWorldService.class);
		return factory;
	}

}
