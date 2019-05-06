package com.itshizhan.shirorbac;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itshizhan.shirorbac.dao")
public class ShiroRbacApplication {

	public static void main(String[] args) {


		SpringApplication.run(ShiroRbacApplication.class, args);
	}

}
