package com.itshizhan.constants;

public enum ResultEnum {
	SUCCESS(1,"success"),
	ERROR_405(405,"请求异常,请检查请求方法POST/GET"),
	ERROR_500(500,"服务异常,请稍后再试"),
	ERROR_50001(50001,"缺少必填的请求参数"),
	ERROR_50002(50002,"缺少请求BODY")
	;

	private Integer code;
	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
