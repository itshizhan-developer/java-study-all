package com.itshizhan.chapter4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itshizhan.chapter4.mapper")
public class Chaper4App {
	public static void main(String[] args) {
		SpringApplication.run(Chaper4App.class,args);
	}
}
