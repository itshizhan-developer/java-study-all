package com.itshizhan.adapter;

// 适配器类
public class PrintBanner extends Banner implements Print {
	@Override
	public void printWeak() {
		showWithParen();
	}

	@Override
	public void printStrong() {
		showWithAster();
	}

	public PrintBanner(String string) {
		super(string);
	}
}
