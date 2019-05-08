package com.itshizhan.framework;

import com.itshizhan.framework.helper.BeanHelper;
import com.itshizhan.framework.helper.ClassHelper;
import com.itshizhan.framework.helper.ControllerHelper;
import com.itshizhan.framework.helper.IocHelper;
import com.itshizhan.framework.util.ClassUtil;

/**
 * 加载相应的helper
 */
public class HelperLoader {
	public static void init() {
		Class<?>[] classList = {
			ClassHelper.class,
			BeanHelper.class,
			//AopHelper.class,
			IocHelper.class,
			ControllerHelper.class
		};
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName());
		}
	}
}
