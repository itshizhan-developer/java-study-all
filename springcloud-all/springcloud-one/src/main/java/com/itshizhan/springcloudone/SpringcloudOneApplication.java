package com.itshizhan.springcloudone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudOneApplication.class, args);
	}

}
