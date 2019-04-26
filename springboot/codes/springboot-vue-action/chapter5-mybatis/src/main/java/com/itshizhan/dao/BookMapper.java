package com.itshizhan.dao;

import com.itshizhan.bean.Book;
import com.itshizhan.bean.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface BookMapper {

	 int addBook(Book book);
	 int deleteBookById(Integer id);
	 int updateBookById(Book book);
	 Book getBookById(Integer id);
	 List<Book> getAllBooks();

	 List<Book> getBooksByPage();

}
