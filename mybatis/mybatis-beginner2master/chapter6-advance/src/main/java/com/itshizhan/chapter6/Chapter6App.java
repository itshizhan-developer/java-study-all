package com.itshizhan.chapter6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itshizhan.chapter6.mapper")
public class Chapter6App {
	public static void main(String[] args) {
		SpringApplication.run(Chapter6App.class,args);
	}
}
