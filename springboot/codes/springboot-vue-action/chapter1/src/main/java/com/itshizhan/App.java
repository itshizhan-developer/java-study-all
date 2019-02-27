package com.itshizhan;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by leeson8888 on 2019/2/20.
 */


@EnableAutoConfiguration
@ComponentScan()
//@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class,args);

	}
}
