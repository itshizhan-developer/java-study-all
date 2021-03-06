package com.itshizhan.chapter2.mapper;

import com.itshizhan.chapter2.bean.SysRole;
import com.itshizhan.chapter2.bean.SysRoleExtend;
import com.itshizhan.chapter2.bean.SysUser;
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

	/**
	 * 查询用户信息和用户的角色信息
	 * @param userId
	 * @return
	 */
	List<SysRoleExtend> selectUsersAndRolesByUserId(Long userId);

	/**
	 * 新增用户
	 * @param sysUser
	 * @return
	 */
	int insertUser (SysUser sysUser);
	/**
	 * 新增用户并返回Id
	 * @param sysUser
	 * @return
	 */
	int insertUserAndGetId (SysUser sysUser);

	/**
	 * 新增用户并返回Id
	 * @param sysUser
	 * @return
	 */
	int insertUserAndSelectKey (SysUser sysUser);

	int updateById(SysUser sysUser);

	int deleteById(Long id);
}
