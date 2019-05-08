package com.itshizhan.framework.helper;

import com.itshizhan.framework.annotation.Inject;
import com.itshizhan.framework.util.ArrayUtil;
import com.itshizhan.framework.util.CollectionUtil;
import com.itshizhan.framework.util.ReflectionUtil;


import java.lang.reflect.Field;
import java.util.Map;

public class IocHelper {
	static {
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (CollectionUtil.isNotEmpty(beanMap)) {
			for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				Field[] beanFields = beanClass.getDeclaredFields();
				if (ArrayUtil.isNotEmpty(beanFields)) {
					for (Field beanField : beanFields) {
						if (beanField.isAnnotationPresent(Inject.class)) {
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if (beanFieldInstance != null) {
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
}
