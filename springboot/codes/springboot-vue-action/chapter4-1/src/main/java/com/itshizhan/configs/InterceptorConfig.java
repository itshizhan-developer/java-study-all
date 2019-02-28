/**
 * Created by leeson8888 on 2019/2/28.
 */
package com.itshizhan.configs;

import com.itshizhan.interceptors.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor())
						.addPathPatterns("/**")
						.excludePathPatterns("/hello");
	}
}
