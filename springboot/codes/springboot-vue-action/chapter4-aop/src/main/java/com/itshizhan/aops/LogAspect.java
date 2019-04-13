package com.itshizhan.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogAspect {
	// 定义切入点: 返回值 包名+类名+方法名(),* 代表任意
	@Pointcut(value = "execution(* com.itshizhan.services.*.*(..))")
	public void pc(){

	}
	@Before(value = "pc()")
	public void before(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("before:"+name+"方法开始执行");
	}

	@After(value = "pc()")
	public void after(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("after:"+name+"方法执行结束");
	}

	@AfterReturning(value = "pc()",returning = "result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String name = joinPoint.getSignature().getName();
		System.out.println("afterReturning:" + name + "方法返回值为:" + result);
	}

	@AfterThrowing(value = "pc()",throwing = "e")
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String name = joinPoint.getSignature().getName();
		System.out.println("afterThrowing:" + name + "方法抛出异常了，异常信息为：" + e.getMessage());
	}

	@Around(value = "pc()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		return pjp.proceed();
	}
}
