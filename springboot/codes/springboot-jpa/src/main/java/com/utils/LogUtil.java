/**
 * Created by leeson8888 on 2018/12/4.
 */
package com.utils;

import com.alibaba.fastjson.JSON;

public class LogUtil {

	public static void logJson(Object object){
		System.out.println("----------------result start------------------");
		System.out.println(JSON.toJSONString(object));
		System.out.println("----------------result end--------------------");
	}
}
