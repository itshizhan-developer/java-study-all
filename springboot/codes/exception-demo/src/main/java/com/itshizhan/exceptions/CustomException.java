/**
 * Created by leeson8888 on 2018/11/1.
 */
package com.itshizhan.exceptions;



public class CustomException extends Exception {


	//无参构造方法
	public CustomException(){
		super();
	}

	//有参的构造方法
	public CustomException(String message){
		super(message);
	}

}