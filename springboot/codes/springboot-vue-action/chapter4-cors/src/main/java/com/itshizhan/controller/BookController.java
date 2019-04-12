package com.itshizhan.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

	@GetMapping("/addbook")
	@CrossOrigin(origins = "http://localhost:5000",allowedHeaders = "*",maxAge = 1800)
	public String addBook(String name) {
		return "received：" + name;
	}

	@DeleteMapping("/deletebook/{id}")
	@CrossOrigin(value = "*",allowedHeaders = "*",methods = { RequestMethod.DELETE })
	public String deleteBook(@PathVariable(value = "id") Integer id){
		return String.valueOf(id);
	}


}
