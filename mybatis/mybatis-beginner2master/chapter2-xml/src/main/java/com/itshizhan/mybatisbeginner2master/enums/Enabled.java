package com.itshizhan.mybatisbeginner2master.enums;

public enum Enabled implements BaseEnum{
	ENABLED(1,"启用"),
	DISABLED(0,"禁用");

	private Integer code;
	private String label;

	Enabled(Integer code, String label) {
		this.code = code;
		this.label = label;
	}

	@Override
	public Integer getCode() {
		return this.code;
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	public static Enabled getEnumByStr(String s){
		if(Enabled.ENABLED.toString().equals(s)){
			return Enabled.ENABLED;
		}
		if(Enabled.DISABLED.toString().equals(s)){
			return Enabled.DISABLED;
		}
		return null;
	}

}
