package com.itshizhan.dao;

import com.itshizhan.bean.NewBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


@Repository
public class BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addBook(NewBook newBook){

		//return jdbcTemplate.update("insert into chapter5_book (name,author) values (?,?)", newBook.getName(), newBook.getAuthor());
		String sql = "insert into chapter5_book (name,author) values (?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			// 指定主键
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,newBook.getName());
			preparedStatement.setString(2,newBook.getAuthor());
			return preparedStatement;
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

}
