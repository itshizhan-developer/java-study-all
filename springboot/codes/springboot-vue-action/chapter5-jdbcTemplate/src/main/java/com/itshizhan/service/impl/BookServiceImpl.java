package com.itshizhan.service.impl;

import com.itshizhan.bean.NewBook;
import com.itshizhan.dao.BookDao;
import com.itshizhan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	public int addBook(NewBook newBook) {
		return bookDao.addBook(newBook);
	}
}
