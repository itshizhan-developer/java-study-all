package com.itshizhan.shirorbac.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FastjsonConfig {
	@Bean
	FastJsonHttpMessageConverter fastJsonHttpMessageConverter () {
		FastJsonHttpMessageConverter converter= new FastJsonHttpMessageConverter () ;
		FastJsonConfig config = new FastJsonConfig ();
		config.setDateFormat("yyyy-MM-dd");
		config.setSerializerFeatures(
			//SerializerFeature.WriteClassName, // 会基于实体类名生成@type字段，自动序列化时有用
			SerializerFeature.WriteMapNullValue,
			SerializerFeature.PrettyFormat,
			SerializerFeature.WriteNullListAsEmpty,
			SerializerFeature.WriteNullStringAsEmpty
		);

		converter.setFastJsonConfig(config);
		return converter;
	}
}
