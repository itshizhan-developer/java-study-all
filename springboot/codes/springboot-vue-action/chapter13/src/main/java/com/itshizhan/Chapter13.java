package com.itshizhan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Chapter13 {
	public static void main(String[] args) {
		SpringApplication.run(Chapter13.class,args);
	}
}
