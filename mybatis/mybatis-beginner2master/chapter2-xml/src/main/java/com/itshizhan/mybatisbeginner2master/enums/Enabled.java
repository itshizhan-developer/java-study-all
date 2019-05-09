package com.itshizhan.mybatisbeginner2master.enums;

public enum Enabled {
	enabled(1,"启用"), //启用
	disabled(0,"禁用");//禁用

	private final int value;
	private final String desc;

	Enabled(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
}
