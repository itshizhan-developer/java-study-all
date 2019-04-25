package com.itshizhan.exception;


import com.alibaba.fastjson.JSONObject;
import com.itshizhan.constants.ResultEnum;
import com.itshizhan.utils.CommonUtil;

import com.itshizhan.utils.StringTools;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


	/**
	 * 缺少请求body，请求未到达
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public JSONObject httpMessageNotReadableException()
	{
		return CommonUtil.errorJson(ResultEnum.ERROR_50002);
	}

	/**
	 * JSON异常
	 * @return
	 */
	@ExceptionHandler(CommonJsonException.class)
	public JSONObject commonJsonException(CommonJsonException e){
		String msg = e.getMsg();
		if(!StringTools.isNullOrEmpty(msg)){
			return CommonUtil.errorJson(e.getResultEnum(),msg);
		}else{
			// msg 为空
			return CommonUtil.errorJson(e.getResultEnum());
		}

	}

	/**
	 * 未知服务异常
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public JSONObject unKnowException()
	{
		return CommonUtil.errorJson(ResultEnum.ERROR_500);
	}

}
