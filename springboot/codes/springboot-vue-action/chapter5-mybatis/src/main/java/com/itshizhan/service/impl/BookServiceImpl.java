package com.itshizhan.service.impl;

import com.itshizhan.bean.Book;
import com.itshizhan.bean.Page;
import com.itshizhan.dao.BookMapper;
import com.itshizhan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookMapper bookMapper;

	public int addBook(Book book) {
		return bookMapper.addBook(book);
	}


	public int deleteBookById(Integer id) {
		return bookMapper.deleteBookById(id);
	}

	public int updateBookById(Book book) {
		return bookMapper.updateBookById(book);
	}

	public Book getBookById(Integer id) {
		return bookMapper.getBookById(id);
	}

	public List<Book> getAllBooks() {
		return bookMapper.getAllBooks();
	}

	public List<Book> getBooksByPage(){
		return bookMapper.getBooksByPage();
	}
}
