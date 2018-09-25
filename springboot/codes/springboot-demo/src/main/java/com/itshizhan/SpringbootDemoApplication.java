package com.itshizhan;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringbootDemoApplication.class, args);
		SpringApplication app = new SpringApplication(SpringbootDemoApplication.class);
		//app.setBannerMode(Banner.Mode.OFF); // 关闭banner
		app.run(args);

	}
}
