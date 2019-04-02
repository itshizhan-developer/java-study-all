package com.itshizhan.config;

import com.itshizhan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userService;
	@Bean
	PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder(10);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth);
		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		http.authorizeRequests()
					.antMatchers ("/admin/**").hasRole ("admin")
					.antMatchers("/db/**").hasRole("dba")
					.antMatchers ("/user/**").hasRole ("user").anyRequest().authenticated()
					.and()
					.formLogin()
					.loginProcessingUrl ("/login").permitAll()
					.and()
					.csrf().disable();

	}
}
