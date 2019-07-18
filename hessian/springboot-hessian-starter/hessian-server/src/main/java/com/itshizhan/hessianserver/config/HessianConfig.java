package com.itshizhan.hessianserver.config;

import com.itshizhan.hessianserver.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

@Configuration
public class HessianConfig {

	@Autowired
	private HelloWorldService helloWorldService;

	/**
	 * 暴露服务
	 * @return
	 */
	@Bean(name = "/HelloWorldService")
	public HessianServiceExporter accountService() {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(helloWorldService);
		exporter.setServiceInterface(HelloWorldService.class);
		return exporter;
	}
}
