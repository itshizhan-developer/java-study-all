/**
 * Created by leeson8888 on 2018/10/22.
 */
package com.itshizhan.springbasic.aop;

import org.springframework.stereotype.Service;


@Service
public class ComputerImp implements Computer {
	@Override
	public int add(int a, int b) {
		System.out.println("add");
		return a + b ;
	}

}
