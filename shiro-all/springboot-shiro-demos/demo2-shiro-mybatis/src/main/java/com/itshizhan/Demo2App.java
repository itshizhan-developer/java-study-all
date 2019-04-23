package com.itshizhan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itshizhan.mapper")
public class Demo2App {
	public static void main(String[] args) {
		SpringApplication.run(Demo2App.class,args);
	}
}
