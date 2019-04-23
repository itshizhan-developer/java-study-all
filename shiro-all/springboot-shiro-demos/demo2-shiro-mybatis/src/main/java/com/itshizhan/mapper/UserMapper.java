package com.itshizhan.mapper;

import com.itshizhan.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	public User findByName(String name);
	public User findById(Integer id);
}
