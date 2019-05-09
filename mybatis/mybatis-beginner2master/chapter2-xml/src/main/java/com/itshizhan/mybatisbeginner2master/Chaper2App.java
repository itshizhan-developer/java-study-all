package com.itshizhan.mybatisbeginner2master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itshizhan.mybatisbeginner2master.mapper")
public class Chaper2App {
	public static void main(String[] args) {
		SpringApplication.run(Chaper2App.class,args);
	}
}
