package com.itshizhan.chapter4.enums;

public class Test {
	public static void main(String[] args) {

		System.out.println(Enabled.ENABLED);
		System.out.println(Enabled.DISABLED);
		System.out.println(Enabled.ENABLED.getCode());
		System.out.println(Enabled.DISABLED.getCode());
		System.out.println(Enabled.ENABLED.getLabel());
		System.out.println(Enabled.DISABLED.getLabel());

		Enabled enabled = Enabled.getEnumByStr("ENABLED");
		System.out.println(enabled);

	}
}
