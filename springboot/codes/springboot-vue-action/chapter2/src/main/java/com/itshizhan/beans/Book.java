package com.itshizhan.beans;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix="book")
public class Book {
	private String name;
	private String author;
	private Float price;

}
