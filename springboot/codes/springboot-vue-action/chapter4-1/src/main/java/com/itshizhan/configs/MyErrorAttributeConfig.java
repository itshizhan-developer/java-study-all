/**
 * Created by leeson8888 on 2019/2/27.
 */
package com.itshizhan.configs;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributeConfig extends DefaultErrorAttributes {
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

		errorAttributes.put("customError","出错了");
		errorAttributes.remove("error");
		return  errorAttributes;
	}
}
