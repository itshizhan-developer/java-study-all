package com.itshizhan.service;

import com.itshizhan.bean.Book;


import java.util.List;


public interface BookService {

	int addBook(Book book);
	int deleteBookById(Integer id);
	int updateBookById(Book book);
	Book getBookById(Integer id);
	List<Book> getAllBooks();

	List<Book> getBooksByPage();
}
