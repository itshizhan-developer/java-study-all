/**
 * Created by leeson8888 on 2018/8/8.
 */
package com.itshizhan;

// 共享数据
public class MyThreadTwo extends Thread {

	int count = 5;

	/*
	public MyThreadTwo(String name){
		super();
		//设置线程名称
		this.setName(name);
	}
	*/


	@Override
	synchronized public void run() {
		super.run();
		count--;
		// 不是有for语句，一直由一个线程进行减法运算
		System.out.println("由"+ this.currentThread().getName()+"计算，count= " + this.count );

	}
}
