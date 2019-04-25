package com.itshizhan.testApp;

import com.itshizhan.constants.ResultEnum;
import com.itshizhan.utils.CommonUtil;
import org.json.JSONObject;

public class TestApp {

	public static void main(String[] args) {
		System.out.println(ResultEnum.SUCCESS.getCode());
		System.out.println(ResultEnum.SUCCESS.getMsg());
		System.out.println(ResultEnum.ERROR_405.getCode());
		System.out.println(ResultEnum.ERROR_405.getMsg());
		System.out.println(new JSONObject()); //{}

		System.out.println(CommonUtil.successJson());
		System.out.println(CommonUtil.successJson("成功"));
	}
}
