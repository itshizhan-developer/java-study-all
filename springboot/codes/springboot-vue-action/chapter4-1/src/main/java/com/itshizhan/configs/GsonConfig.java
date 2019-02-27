/**
 * Created by leeson8888 on 2019/2/22.
 */
package com.itshizhan.configs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;


@Configuration
public class GsonConfig {

	@Bean
	GsonHttpMessageConverter gsonHttpMessageConverter() {
		GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd");
		builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
		Gson gson = builder.create();
		converter.setGson(gson);
		return converter;

	}

}
