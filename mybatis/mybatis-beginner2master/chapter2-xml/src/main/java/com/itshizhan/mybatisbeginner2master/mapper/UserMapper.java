package com.itshizhan.mybatisbeginner2master.mapper;

import com.itshizhan.mybatisbeginner2master.bean.SysRole;
import com.itshizhan.mybatisbeginner2master.bean.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id) ;

	/**
	 * 查询所有用户
	 * @return
	 */
	List<SysUser> selectAll ();

	/**
	 * 根据用户id获取角色信息
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);
}
