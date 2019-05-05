package com.itshizhan.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringTest {
	public static void main(String[] args) {
		//生成文件名称通用方法
		String suffixName = ".png";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		Random r = new Random();
		StringBuilder tempName = new StringBuilder();
		System.out.println(tempName);

		tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
		String newFileName = tempName.toString();
		System.out.println(newFileName);
	}
}
