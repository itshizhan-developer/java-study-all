/**
 * Created by leeson8888 on 2018/11/12.
 */
package com.itshizhan.aop;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebControllerAop {

	@Pointcut("execution(* com.itshizhan.controller.*.*(..))")
	public void webLog(){}

	@Before("webLog()")
	public void doBefore(){
		System.out.println("我是前置通知!!!");
	}

	@After("webLog()")
	public void doAfter(){
		System.out.println("我是后置通知!!!");
	}

	@AfterThrowing("webLog()")
	public void hasException(){
		System.out.println("出错了!!!");
	}

}
