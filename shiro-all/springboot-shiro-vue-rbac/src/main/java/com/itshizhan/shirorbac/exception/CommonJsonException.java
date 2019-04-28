package com.itshizhan.shirorbac.exception;


import com.itshizhan.shirorbac.constants.ResultEnum;

public class CommonJsonException extends RuntimeException {

	private ResultEnum resultEnum;
	private String msg;

	public CommonJsonException(ResultEnum resultEnum) {
		this.resultEnum = resultEnum;
	}

	public CommonJsonException(ResultEnum resultEnum, String msg) {
		this.resultEnum = resultEnum;
		this.msg = msg;
	}

	public ResultEnum getResultEnum() {
		return resultEnum;
	}

	public String getMsg() {
		return msg;
	}

}
