package com.itshizhan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private Integer uid;
	private String  uname;
	private String  password;

	private Pet pet;

	public User() {
		System.out.println("无参构造执行------");
	}


}
