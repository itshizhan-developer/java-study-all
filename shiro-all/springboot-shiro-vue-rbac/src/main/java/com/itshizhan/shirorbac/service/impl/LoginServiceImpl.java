package com.itshizhan.shirorbac.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.itshizhan.shirorbac.constants.ResultEnum;
import com.itshizhan.shirorbac.dao.LoginDao;
import com.itshizhan.shirorbac.service.LoginService;
import com.itshizhan.shirorbac.utils.CommonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

	private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);


	@Autowired
	private LoginDao loginDao;

	/**
	 * shiro 登录服务
	 * @param jsonObject
	 * @return
	 */
	public JSONObject authLogin(JSONObject jsonObject) {
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		Subject currentUser = SecurityUtils.getSubject();

		//UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		//Md5Hash hash = new Md5Hash(password,username,2);
		password = CommonUtil.pwdToMd5(password,username);
		System.out.println("password md5 hash:" + password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
			// 登录成功

			return CommonUtil.successJson(ResultEnum.SUCCESS_20000.getMsg());

		}catch (AuthenticationException e){
			// 登录失败
			return CommonUtil.errorJson(ResultEnum.ERROR_20002);

		}

	}

	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public JSONObject getUser(String username, String password) {
		JSONObject jsonObject = loginDao.getUser(username, password);
		logger.info("正在登录，根据用户名和密码查询用户如下：");
		logger.info(JSONObject.toJSONString(jsonObject));
		return jsonObject;
	}
}
