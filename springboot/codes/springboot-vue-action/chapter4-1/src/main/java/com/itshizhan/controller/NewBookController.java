/**
 * Created by leeson8888 on 2019/2/27.
 */
package com.itshizhan.controller;

import com.itshizhan.entity.Author;
import com.itshizhan.entity.NewBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NewBookController {

	@GetMapping("/bookAuthor")
	public Map<String,Object> book(@ModelAttribute("a") NewBook book, @ModelAttribute("b") Author author){
		//return book.toString() + ">>" + author.toString();

		Map<String,Object> map = new HashMap<>();
		map.put("book",book);
		map.put("author",author);
		return  map;

	}
}
