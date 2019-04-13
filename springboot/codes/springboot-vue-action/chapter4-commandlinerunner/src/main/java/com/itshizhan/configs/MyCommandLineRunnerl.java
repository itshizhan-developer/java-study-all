package com.itshizhan.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
//@Order(1)
public class MyCommandLineRunnerl implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Runner1 >> " +Arrays.toString(args)) ;
	}
}
