package com.itshizhan.mapper;

import com.itshizhan.model.Role;
import com.itshizhan.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
	User loadUserByUsername(String username);
	List<Role> getUserRolesByUid(Integer id);
}
