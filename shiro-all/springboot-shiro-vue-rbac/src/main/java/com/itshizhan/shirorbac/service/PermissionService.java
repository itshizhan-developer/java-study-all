package com.itshizhan.shirorbac.service;

import com.alibaba.fastjson.JSONObject;

public interface PermissionService {

	/**
	 * 根据登录用户名查询某用户的角色、菜单列表、权限列表
	 * @param username
	 * @return
	 */
	JSONObject getUserPermission(String username);
}
