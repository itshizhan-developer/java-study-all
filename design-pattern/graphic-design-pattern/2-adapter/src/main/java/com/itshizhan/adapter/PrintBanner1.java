package com.itshizhan.adapter;

public class PrintBanner1 extends Print1 {

	public PrintBanner1(String string) {
		this.banner = new Banner(string);
	}

	private Banner banner;


	@Override
	public void printWeak() {
		banner.showWithParen();
	}

	@Override
	public void printStrong() {
		banner.showWithAster();
	}
}
