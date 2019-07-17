package com.itshizhan.starterdemo.consumer.systemtask;

import com.itshizhan.starterdemo.DemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunnerl implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/consumer.xml");
		context.start();
		DemoService demoService = (DemoService) context.getBean("demoService"); // get remote service proxy
		while (true) {
			try {
				Thread.sleep(1000);
				String hello = demoService.sayHello("world"); // call remote method
				System.out.println(hello); // get result
			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
		}
	}
}
