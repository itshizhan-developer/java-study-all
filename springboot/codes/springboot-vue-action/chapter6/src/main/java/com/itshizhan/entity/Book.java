/**
 * Created by leeson8888 on 2019/2/28.
 */
package com.itshizhan.entity;


import java.io.Serializable;

public class Book implements Serializable {
	private Integer id;
	private String name;
	private String author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book{" +
						"id=" + id +
						", name='" + name + '\'' +
						", author='" + author + '\'' +
						'}';
	}
}
