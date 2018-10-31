/**
 * Created by leeson8888 on 2018/11/1.
 */
package com.itshizhan.exceptions;

import com.itshizhan.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ControllerAdviceHandler {

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e) {
		e.printStackTrace();
		return new Result(500,"java.lang.ArithmeticException: / by zero");
	}

}
