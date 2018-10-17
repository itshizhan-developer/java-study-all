package com.itshizhan.type;

/**
 * Created by leeson8888 on 2018/10/17.
 */
public enum Enabled {
	enabled(1), // 启用
	disabled(0);// 禁用

	private final int value;

	private  Enabled(int i) {
		this.value = i;
	}
	int getValue(){
		return  value;
	}
}
