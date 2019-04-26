package com.itshizhan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private Integer id;
	private String  name;
	private String  author;

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}
}
