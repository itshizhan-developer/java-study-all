package com.itshizhan.chapter2.enums;


public class EnumUtils {
	//枚举工作类来完成从枚举 code 值获得枚举实例
	public static <T extends Enum<?> & BaseEnum> T codeOf(Class<T> enumClass, int code) {
		T[] enumConstants = enumClass.getEnumConstants();
		for (T t : enumConstants) {
			if (t.getCode() == code) {
				return t;
			}
		}
		return null;
	}
}
