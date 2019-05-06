package com.itshizhan.shirorbac.service;

import com.alibaba.fastjson.JSONObject;

public interface LoginService {
	//shiro 授权登录
	JSONObject authLogin(JSONObject jsonObject);

	JSONObject getUser(String loginName, String password);
}
