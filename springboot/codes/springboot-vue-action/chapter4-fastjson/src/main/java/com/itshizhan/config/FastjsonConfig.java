package com.itshizhan.config;

import com.alibaba.fastjson.parser.Feature;
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
							//SerializerFeature.WriteClassName, // 会生成@type 字段
							SerializerFeature.WriteMapNullValue,
							SerializerFeature.PrettyFormat,
							SerializerFeature.WriteNullListAsEmpty,
							SerializerFeature.WriteNullStringAsEmpty
			);

			converter.setFastJsonConfig(config);
			return converter;
		}
}
