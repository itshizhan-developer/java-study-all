package com.itshizhan.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itshizhan.beans.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



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
}
