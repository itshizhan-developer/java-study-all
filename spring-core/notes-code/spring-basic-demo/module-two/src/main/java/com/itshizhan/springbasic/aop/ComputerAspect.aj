package com.itshizhan.springbasic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by leeson8888 on 2018/10/22.
 */


@Component
@Aspect
class ComputerAspect {

	//@Pointcut("execution(* com.itshizhan.springbasic.aop.ComputerImp.*(..)")

	@Pointcut("execution(public int com.itshizhan.springbasic.aop.*.*(int,int))")
	public void pointCut(){}


	@Before("pointCut()")
	public void  b(JoinPoint joinPoint){
		System.out.println(joinPoint);
		System.out.println("调用方法前……");
	}

	@After("pointCut()")
	public void  a(){
		System.out.println("调用方法后……");
	}

}
