package com.itshizhan.starterdemo.provider.systemtask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunnerl implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/privider.xml");
		context.start();
		System.in.read(); // press any key to exit

	}
}

