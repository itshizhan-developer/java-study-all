package com.itshizhan.controllers;

import com.itshizhan.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	Book book;
	@GetMapping("/")
	public String sayHello(){
		return "hello Chapter2";
	}

	@GetMapping("/books")
	public Book getbook(){
		return book;
	}
}
