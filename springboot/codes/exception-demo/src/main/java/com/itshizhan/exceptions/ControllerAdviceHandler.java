/**
 * Created by leeson8888 on 2018/11/1.
 */
package com.itshizhan.exceptions;

import com.itshizhan.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ControllerAdviceHandler {

	Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(value = CustomException.class)
	public Result handleCustomException(Exception e) {
		e.printStackTrace();
		return new Result(500,e.getMessage());
	}


	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e) {
	  //e.printStackTrace();
		// 级别由低到高 trace<debug<info<warn<error
		logger.trace("这是一个trace日志...");
		logger.debug("这是一个debug日志...");
		// SpringBoot默认是info级别，只会输出info及以上级别的日志
		logger.info("这是一个info日志...");
		logger.warn("这是一个warn日志...");
		logger.error("这是一个error日志...");

		return new Result(500,"java.lang.ArithmeticException: / by zero");
	}

}
