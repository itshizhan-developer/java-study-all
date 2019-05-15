package com.itshizhan.chapter2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itshizhan.chapter2.mapper")
public class Chaper2App {
	public static void main(String[] args) {
		SpringApplication.run(Chaper2App.class,args);
	}
}
