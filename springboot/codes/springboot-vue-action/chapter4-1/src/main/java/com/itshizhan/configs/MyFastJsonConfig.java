/**
 * Created by leeson8888 on 2019/2/22.
 */
package com.itshizhan.configs;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFastJsonConfig {

	@Bean
	FastJsonHttpMessageConverter fastJsonHttpMessageConverter () {
		FastJsonHttpMessageConverter converter= new FastJsonHttpMessageConverter () ;
		FastJsonConfig config = new FastJsonConfig ();
		config.setDateFormat("yyyy-MM-dd");
		config.setSerializerFeatures(
						SerializerFeature.WriteClassName,
						SerializerFeature.WriteMapNullValue,
						SerializerFeature.PrettyFormat,
						SerializerFeature.WriteNullListAsEmpty,
						SerializerFeature.WriteNullStringAsEmpty
		);

		converter.setFastJsonConfig(config);
		return converter;
	}
}
