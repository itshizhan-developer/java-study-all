/**
 * Created by leeson8888 on 2018/9/25.
 */
package com.itshizhan.controller;

import com.itshizhan.Entity.BooKEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@RestController
@RequestMapping("index")
public class IndexController {

	private String url = "http%3A%2F%2Fstem.ooowin.cc%2Finspiration_h5.html%3Fid%3D12";

	@Autowired
	BooKEntity book;


	@Value("${mypro.bookName}")
	private String bookName;

	@Value("${mypro.bookPrice}")
	private String bookPrice;

	@RequestMapping("/helloWorld")
	public String sayHello(){

		try {
			String javaUrl  = URLDecoder.decode(url,"UTF-8");
			System.out.println("javaUrl----:"+javaUrl);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


		return "hello spring boot,no Banner";
	}

	@RequestMapping("/getBookName")
	public String getBookName(){
		return "The BookName is: " + this.bookName+",the price is: "+ this.bookPrice;
	}

	@RequestMapping("/getBookAuthorInfo")
	public String getBookAuthorInfo(){
		return "The Book Author name is: " + book.getName()+",the age is: "+ book.getAge();
		//return "getBookAuthorInfo";
	}



}
