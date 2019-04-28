package com.itshizhan.shirorbac.utils;

import com.alibaba.fastjson.JSONObject;
import com.itshizhan.shirorbac.constants.ResultEnum;
import com.itshizhan.shirorbac.exception.CommonJsonException;

/**
 * 通用工具类
 */
public class CommonUtil {

	/**
	 * 返回一个成功的JSON，没有data
	 * @return
	 */
	public static JSONObject successJson(){
		JSONObject jsonObject = successJson(new JSONObject());
		jsonObject.remove("data");
		return jsonObject;
	}

	/**
	 * 返回一个成功的JSON，并且有data数据，即使data为 空 或null
	 * @param data
	 * @return
	 */
	public static JSONObject successJson(Object data){
		JSONObject jsonObject = new JSONObject(true); // 确保jsonObject有序
		jsonObject.put("code", ResultEnum.SUCCESS.getCode());
		jsonObject.put("msg",ResultEnum.SUCCESS.getMsg());
		jsonObject.put("data",data);
		return jsonObject;
	}


	/**
	 * 返回一个错误的JSON
	 * @param resultEnum
	 * @return
	 */
	public static JSONObject errorJson(ResultEnum resultEnum) {
		JSONObject resultJson = new JSONObject(true);
		resultJson.put("code", resultEnum.getCode());
		resultJson.put("msg", resultEnum.getMsg());
		return resultJson;
	}

	/**
	 * 返回一个错误的JSON,但是自定义msg
	 * @param resultEnum
	 * @return
	 */
	public static JSONObject errorJson(ResultEnum resultEnum,String msg) {
		JSONObject resultJson = new JSONObject(true);
		resultJson.put("code", resultEnum.getCode());
		resultJson.put("msg", msg);
		return resultJson;
	}


	/**
	 * 验证是否含有全部必填字段
	 * @param requiredColumns 必填的参数字段名称 逗号隔开 比如"userId,name,telephone"
	 */
	public static void hasAllRequired(final JSONObject jsonObject, String requiredColumns) {
		if(jsonObject.isEmpty()){
			throw new CommonJsonException(ResultEnum.ERROR_50002);
		}
		if (!StringTools.isNullOrEmpty(requiredColumns)) {
			//验证字段非空
			String[] columns = requiredColumns.split(",");
			String missCol = "";
			for (String column : columns) {
				Object val = jsonObject.get(column.trim());
				// 没有必选的参数
				if (StringTools.isNullOrEmpty(val)) {
					missCol += column + " ";
				}
			}
			if (!StringTools.isNullOrEmpty(missCol)) {
				  throw new CommonJsonException(
				  				ResultEnum.ERROR_50001,
									ResultEnum.ERROR_50001.getMsg() + ":" + missCol.trim());
			}
		}

	}


}
