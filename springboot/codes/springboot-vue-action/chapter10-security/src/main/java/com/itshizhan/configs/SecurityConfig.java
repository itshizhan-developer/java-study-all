package com.itshizhan.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Bean
	PasswordEncoder passwordEncoder(){
		//return NoOpPasswordEncoder.getInstance(); // 已经废弃
		return  new BCryptPasswordEncoder(10);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth);
		auth.inMemoryAuthentication()
						.withUser("root").password("123").roles("ADMIN", "DBA")
						.and()
						.withUser("admin").password("123").roles("ADMIN", "USER")
						.and()
						.withUser("sang").password("123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		http.authorizeRequests()
						.antMatchers("/admin/**")
						.hasRole("ADMIN")
						.antMatchers("/user/**")
						.access("hasAnyRole('ADMIN','USER')")
						.antMatchers("/db/**")
						.access("hasRole('ADMIN') and hasRole('DBA')")
						.anyRequest()
						.authenticated()
						.and()
						.formLogin()
						.loginPage("/login_page")
						.loginProcessingUrl("/login")
						.usernameParameter("name")
						.passwordParameter("password")
						.successHandler(new AuthenticationSuccessHandler() {
							@Override
							public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
								Object principal = auth.getPrincipal();
								resp.setContentType("application/json;charset=utf-8");
								PrintWriter out = resp.getWriter();
								resp.setStatus(200);
								Map<String,Object> map = new HashMap<>();
								map.put("status",200);
								map.put("msg","principal");
								ObjectMapper objectMapper = new ObjectMapper();
								out.write(objectMapper.writeValueAsString(map));
								out.flush();
								out.close();

							}
						})
						.failureHandler(new AuthenticationFailureHandler() {
							@Override
							public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
								resp.setContentType("application/json;charset=utf-8");
								PrintWriter out = resp.getWriter();
								resp.setStatus(401);
								Map<String, Object> map = new HashMap<>();
								map.put("status", 401);
								if (e instanceof LockedException) {
									map.put("msg", "账户被锁定，登录失败!");
								} else if (e instanceof BadCredentialsException) {
									map.put("msg", "账户名或密码输入错误，登录失败!");
								} else if (e instanceof DisabledException) {
									map.put("msg", "账户被禁用，登录失败!");
								} else if (e instanceof AccountExpiredException) {
									map.put("msg", "账户已过期，登录失败!");
								} else if (e instanceof CredentialsExpiredException) {
									map.put("msg", "密码已过期，登录失败!");
								} else {
									map.put("msg", "登录失败!");
								}
								ObjectMapper om = new ObjectMapper();
								out.write(om.writeValueAsString(map));
								out.flush();
								out.close();
							}
						})
						.permitAll()
						.and()
						.csrf()
						.disable();
	}
}
