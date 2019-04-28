package com.itshizhan.shirorbac.exception;


import com.alibaba.fastjson.JSONObject;

import com.itshizhan.shirorbac.constants.ResultEnum;
import com.itshizhan.shirorbac.utils.CommonUtil;
import com.itshizhan.shirorbac.utils.StringTools;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
	 * HttpRequestMethodNotSupportedException :Request method 'GET' not supported
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public JSONObject httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
		String msg = e.getMessage();
		if(!StringTools.isNullOrEmpty(msg)){
			return CommonUtil.errorJson(ResultEnum.ERROR_405,msg);
		}else{
			// msg 为空
			return CommonUtil.errorJson(ResultEnum.ERROR_405);
		}

	}

	/**
	 * 未知服务异常
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public JSONObject unKnowException(Exception e)
	{
		e.printStackTrace();
		return CommonUtil.errorJson(ResultEnum.ERROR_500);
	}

}
