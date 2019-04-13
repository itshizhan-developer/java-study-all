package com.itshizhan.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String getUserById(Integer id){
		System.out.println("getUserById = [" + id + "]");
		return "user:" + id.toString();
	}

	public void deleteUserById(Integer id){
		id = 1/0;
		System.out.println("deleteUserById = [" + id + "]");
	}



}
