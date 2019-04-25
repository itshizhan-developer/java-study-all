package com.itshizhan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itshizhan.constants.ResultEnum;
import com.itshizhan.utils.CommonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

	@GetMapping("/json1")
	public JSONObject json1(@RequestParam Integer index, @RequestBody JSONObject jsonObject){
		System.out.println(index);
		System.out.println(jsonObject);
		System.out.println(jsonObject.getIntValue("pageIndex"));
		System.out.println(jsonObject.getIntValue("pageSize"));

		return CommonUtil.successJson();
	}
	@GetMapping("/json2")
	public JSONObject json2(){
		return CommonUtil.successJson(new JSONArray());
	}

	@GetMapping("/json3")
	public JSONObject json3(){
		return CommonUtil.errorJson(ResultEnum.ERROR_405);
	}

	@GetMapping("/json4")
	public String json4(@RequestBody JSONObject requestJson)  {
		 CommonUtil.hasAllRequired(requestJson,"name,password");
		 return "请求成功";
	}
}
