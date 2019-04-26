package com.itshizhan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itshizhan.bean.Book;
import com.itshizhan.bean.Page;
import com.itshizhan.service.BookService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class BookController {

//	int addBook(Book book);
//	int deleteBookById(Integer id);
//	int updateBookById(Book book);
//	Book getBookById(Integer id);
//	List<Book> getAllBooks();

	@Autowired
	BookService bookService;

	@GetMapping("/addBook")
	public String addBook(){
			Book b1 = new Book("三国演义2019版","罗贯中");
			int rows =bookService.addBook(b1);
			if(rows>0){
				return "add success: 返回" + rows + "条记录，id为" + b1.getId();
			}
			return "add failue";
	}

	@GetMapping("/deleteBookById")
	public String deleteBookById(@RequestParam Integer id){
		int rows =bookService.deleteBookById(id);
		if(rows>0){
			return "delete success";
		}
		return "delete failue";
	}

	@GetMapping("/updateBookById")
	public String updateBookById(@RequestParam Integer id){

		Book b2 = bookService.getBookById(id);
		b2.setName("三国演义--修改了");
		b2.setAuthor("luoGuanZhong");
		int rows = bookService.updateBookById(b2);
		if(rows>0){
			return "updateBookById success";
		}
		return "updateBookById failue";
	}

	@GetMapping("/getBookById")
	public Book getBookById(@RequestParam Integer id){
		Book book = bookService.getBookById(id);
		return book;
	}

	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks(){
		List<Book> list = bookService.getAllBooks();
		return list;
	}


	@GetMapping("/getBookByPage")
	public String  getBookByPage(Page page) throws JsonProcessingException {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Book> list = bookService.getBooksByPage();
		PageInfo<Book> bookPageInfo = new PageInfo<>(list);
		if(bookPageInfo!=null){
			Map<String,Object> map = new HashMap<>();
			map.put("code",1);
			map.put("msg","success");
			map.put("list",bookPageInfo.getList());
			map.put("total",bookPageInfo.getTotal());
			map.put("pages",bookPageInfo.getPages());
			map.put("pageNum",bookPageInfo.getPageNum());
			map.put("pageSize",bookPageInfo.getPageSize());
			return new ObjectMapper().writeValueAsString(map);
		}else{
			return "查询报错";
		}

	}



}
