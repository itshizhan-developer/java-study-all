package com.itshizhan.shirorbac.shiro;

import com.alibaba.fastjson.JSONObject;
import com.itshizhan.shirorbac.constants.ResultEnum;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", ResultEnum.ERROR_20001.getCode());
		jsonObject.put("msg", ResultEnum.ERROR_20001.getMsg());
		PrintWriter out = null;
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			res.setCharacterEncoding("UTF-8");
			res.setContentType("application/json");
			out = response.getWriter();
			out.println(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
		//如果返回false表示该拦截器实例已经处理了，将直接返回即可
		return false;
	}



	/**
	 *  针对spring-shiro 老版本
	 *  重写了 FormAuthenticationFilter后，匿名访问也被拦截了
	 *
	 */

		@Bean
		public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
			FilterRegistrationBean registration = new FilterRegistrationBean(filter);
			registration.setEnabled(false);
			return registration;
	}

}
