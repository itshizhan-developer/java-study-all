/**
 * Created by leeson8888 on 2019/2/28.
 */
package com.itshizhan.controller;

import com.itshizhan.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@GetMapping("/setBook")
	public String setBook(){

		ValueOperations<String,String> ops1 = stringRedisTemplate.opsForValue();
		ops1.set("name","三国演义");
		Book book = new Book();
		book.setId(1);
		book.setName("三国演义");
		book.setAuthor("罗贯中");

		ValueOperations ops2 = redisTemplate.opsForValue();
		ops2.set("bookInfo",book);
		System.out.println("Redis 设置成功");
		return  "Redis 设置成功";
	}

	@GetMapping("/getBook")
	public String getBook(){

		ValueOperations<String,String> ops1 = stringRedisTemplate.opsForValue();
		String name = ops1.get("name");

		return name;
	}

	@GetMapping("/getBookInfo")
	public Book getBookInfo(){
		ValueOperations ops2 = redisTemplate.opsForValue();
		Book book = (Book) ops2.get("bookInfo");
		return book;
	}

}
