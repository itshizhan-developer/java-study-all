package com.itshizhan.shirorbac.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao {
	JSONObject getUserPermission(String username);
}
