/**
 * Created by leeson8888 on 2019/2/20.
 */
package com.itshizhan.controller;

import com.itshizhan.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

	@RequestMapping("/books")
	public ModelAndView Books(){
		ModelAndView mv =new ModelAndView();

		List<Book> books = new ArrayList<>();
		Book b1 = new Book();
		b1.setBookId(1);
		b1.setBookName("三国演义");
		b1.setBookAuthor("罗贯中");

		Book b2 = new Book();
		b2.setBookId(2);
		b2.setBookName("三体");
		b2.setBookAuthor("刘欣慈");

		books.add(b1);
		books.add(b2);

		mv.addObject("books",books);

		mv.setViewName ("books");
		return mv;
	}
}
