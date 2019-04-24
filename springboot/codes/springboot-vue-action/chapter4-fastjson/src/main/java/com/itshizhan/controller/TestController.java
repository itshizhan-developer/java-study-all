package com.itshizhan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itshizhan.entity.Student;
import com.itshizhan.entity.StudyCourse;
import com.itshizhan.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

	@GetMapping("/")
	public String toHello() {
		return "hello fastJson";
	}

	@GetMapping("/testJson")
	public User testJson() {
		User user = new User(1, "jack", 29, "123456");
		return user;
	}

	@GetMapping("/toJson")
	public String toJson() {
		User user = new User(1, "jack", 29, "123456");
		return JSON.toJSONString(user);
	}

	@GetMapping("/parseObject")
	public JSONObject parseObject() {
		String text = "{\"age\":29,\"id\":1,\"name\":\"jack\"}";
		JSONObject jsonObject = JSONObject.parseObject(text);
		return jsonObject;
	}

	@GetMapping("/parseObject1")
	public User parseObject1() {
		String text = "{\"age\":29,\"id\":1,\"name\":\"jack\"}";
		User user = JSONObject.parseObject(text, User.class);
		return user;

	}

	@GetMapping("/javaToJSONObject")
	public JSONObject javaToJSONObject() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Student stu1 = new Student();
		stu1.setDateOfBirth(sdf.parse("1998-11-11 12:00:01"));
		stu1.setFullName("Jack");
		stu1.setStudyCourse(new StudyCourse("python"));

		return JSONObject.parseObject(JSON.toJSONString(stu1));

	}


	@GetMapping("/javaToJsonArray")
	public JSONArray javaToJson() throws ParseException {

		List<Student> list = new ArrayList<Student>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


		Student stu1 = new Student();
		stu1.setDateOfBirth(sdf.parse("1998-11-11"));
		stu1.setFullName("Jack");
		stu1.setStudyCourse(new StudyCourse("python"));

		Student stu2 = new Student();
		stu2.setDateOfBirth(sdf.parse("1998-11-11"));
		stu2.setFullName("Tom");
		stu2.setStudyCourse(new StudyCourse("springboot"));

		list.add(stu1);
		list.add(stu2);

		return JSONArray.parseArray(JSON.toJSONString(list));

	}



	@GetMapping("/toJsonObject")
	public JSONObject toJsonObject() {
		//User user = new User(1,"jack",29,"123456");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("age", 10);
		jsonObject.put("name", "Jack ");
		jsonObject.put("birthDay", "2019/12/12 12:12:12");

		return jsonObject;
	}

}
