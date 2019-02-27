/**
 * Created by leeson8888 on 2019/2/22.
 */
package com.itshizhan.controller;


import com.itshizhan.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BookController {

	@GetMapping("/book")
	public Book book(){


		Book book = new Book();
		book.setAuthor("罗贯中");
		book.setName("三国演义");
		book.setPrice(30f);
		book.setPublicationDate(new Date());

		return  book;

	}
}
