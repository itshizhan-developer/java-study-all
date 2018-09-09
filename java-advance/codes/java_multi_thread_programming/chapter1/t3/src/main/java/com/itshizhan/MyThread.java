/**
 * Created by leeson8888 on 2018/8/8.
 */
package com.itshizhan;

public class MyThread extends Thread {
	int count = 5;
	public MyThread(String name){
		super();
		//设置线程名称
		this.setName(name);
	}

	@Override
	public void run() {
		super.run();
//		while (count>0){
//			count--;
//			System.out.println("由"+ this.currentThread().getName()+"计算，count= " + this.count );
//		}
	}
}
