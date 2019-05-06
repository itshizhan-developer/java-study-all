package com.itshizhan.shirorbac.constants;

/***
 * 200 开头，登录授权相关
 * 400 开头：客户端请求详情
 * 500 开头：服务端异常
 *
 */

public enum ResultEnum {
	SUCCESS(1,"success"),
	SUCCESS_20000(20000,"登录成功"),

	ERROR_405(405,"请求异常,请检查请求方法POST/GET"),
	ERROR_500(500,"服务异常,请稍后再试"),


	ERROR_20001(20001,"未登录或登录以及过期"),
	ERROR_20002(20002,"登录失败，用户名或密码错误"),


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
