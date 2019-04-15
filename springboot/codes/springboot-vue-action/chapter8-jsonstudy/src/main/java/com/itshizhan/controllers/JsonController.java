package com.itshizhan.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itshizhan.beans.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RestController
public class JsonController {

	@GetMapping("/json")
	public Student jsonTest(){
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Jack\", \"age\":21}";

		//map json to student
		try {
			Student student = mapper.readValue(jsonString, Student.class);
			System.out.println(student);

			jsonString = mapper.writeValueAsString(student);
			System.out.println(jsonString);
			return student;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Student();

	}

	@GetMapping("/simpleJson")
	public String simpleJson(){
		ObjectMapper mapper = new ObjectMapper();

		Map<String,Object> studentMap = new HashMap<>();
		int[] marks = {1,2,3};
		Student student = new Student();
		student.setAge(18);
		student.setName("Jack");
		// JAVA Object
		studentMap.put("student", student);
		// JAVA String
		studentMap.put("name", "Mahesh Kumar");
		// JAVA Boolean
		studentMap.put("verified", Boolean.FALSE);
		// Array
		studentMap.put("marks", marks);

		String studentJson;


		try {
			studentJson = mapper.writeValueAsString(studentMap);
			System.out.println(studentJson);
			mapper.writeValue(new File("/Users/leeson8888/student/student.json"), studentMap);



		} catch (Exception e) {
			e.printStackTrace();
		}

		return "simpleJson";
	}
}
