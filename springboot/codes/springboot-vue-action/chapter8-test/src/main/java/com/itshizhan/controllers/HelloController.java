package com.itshizhan.controllers;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHello(String name){
		return "hello " + name + " !";
	}

	@PostMapping("/book")
	public String addBook(@RequestBody Book book)  {
		return book.toString();
	}
}
