package com.itshizhan.dao;

import com.itshizhan.model.SysUser;

import java.util.List;

/**
 * Created by leeson8888 on 2018/10/17.
 */
public interface UserMapper {

	/**
	 * 根据id查询系统用户
	 * @param id
	 * @return
	 */
	SysUser selectUserById(Long id);

	List<SysUser> selectAllUser();

}
