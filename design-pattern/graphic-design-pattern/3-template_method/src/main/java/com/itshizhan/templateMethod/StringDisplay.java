package com.itshizhan.templateMethod;

public class StringDisplay extends AbstractDisplay {
	private String string;
	private int width;

	public StringDisplay(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}

	private void printLine(){
		System.out.print("+");
		for (int i=0;i<width;i++){
			System.out.print("-");
		}
		System.out.println("+");
	}

	@Override
	void open() {
		printLine();
	}

	@Override
	void print() {
		System.out.println("|" + string + "|");
	}

	@Override
	void close() {
		printLine();
	}
}
