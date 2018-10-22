/**
 * Created by leeson8888 on 2018/10/22.
 */
package com.itshizhan.springbasic;

import com.itshizhan.springbasic.aop.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {


	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("springApplication.xml");

		Computer computer = (Computer) ac.getBean("computerImp");


		System.out.println(computer.add(5,5));


	}
}
