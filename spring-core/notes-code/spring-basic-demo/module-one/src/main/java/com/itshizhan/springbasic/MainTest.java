/**
 * Created by leeson8888 on 2018/10/21.
 */
package com.itshizhan.springbasic;

import com.itshizhan.springbasic.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		Person p1 = (Person) ac.getBean("p1");

		System.out.println(p1);
	}

}
