/**
 * Created by leeson8888 on 2019/2/27.
 */
package com.itshizhan.configs;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class MyErrorResolver implements ErrorViewResolver {
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest httpServletRequest,
																			 HttpStatus httpStatus,
																			 Map<String, Object> map) {

		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("customError","处错了");

		//最后一个 Map 参数就是 SpringBoot提供的默认的 5 条 Error1言 息
		modelAndView.addAllObjects(map);

		return modelAndView;
	}
}
