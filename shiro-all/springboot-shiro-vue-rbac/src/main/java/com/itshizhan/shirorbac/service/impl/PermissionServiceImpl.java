package com.itshizhan.shirorbac.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.itshizhan.shirorbac.dao.PermissionDao;
import com.itshizhan.shirorbac.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDao permissionDao;
	/**
	 * 查询某用户的 角色  菜单列表   权限列表
	 */
	@Override
	public JSONObject getUserPermission(String username) {
		JSONObject userPermission = getUserPermissionFromDB(username);
		return userPermission;
	}

	/**
	 * 从数据库查询用户权限信息
	 */
	private JSONObject getUserPermissionFromDB(String username) {
		JSONObject userPermission = permissionDao.getUserPermission(username);
		//TODO

		return userPermission;

	}


}
