package com.itshizhan.service;

import com.itshizhan.domain.User;

public interface UserService {
	public User findByName(String name);
	public User findById(Integer id);
}
