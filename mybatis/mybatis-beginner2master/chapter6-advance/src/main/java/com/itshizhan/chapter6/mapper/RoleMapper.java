package com.itshizhan.chapter6.mapper;


import com.itshizhan.common.bean.SysRole;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleMapper {
	SysRole selectRoleById(Long id);
}
