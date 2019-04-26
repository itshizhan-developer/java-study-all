package com.itshizhan.controller;

import com.itshizhan.bean.NewBook;
import com.itshizhan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping("/addBook")
	@ResponseBody
	public String addBook(){
		NewBook b1 = new NewBook();
		b1.setName("nodejs从入门到实战");
		b1.setAuthor("itshizhan");
		int i = bookService.addBook(b1); // 返回的是最后插入的主键
		System.out.println("addBook:" + i);
		if(i>0){
			return "addbook success:" + i;
		}else{
			return "addbook failue";
		}

	}

}
