package com.itshizhan.chapter6.mapper;


import com.itshizhan.common.bean.SysUser;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

	SysUser selectUserAndRoleById(Long id);

	SysUser selectUserAndRoleById1(Long id);

	SysUser selectUserAndRoleById2(Long id);

	SysUser selectUserAndRoleById3(Long id);

}
