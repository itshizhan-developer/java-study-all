package com.itshizhan.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@JSONField(name = "personAge",serialize = false)
	private int age;

	@JSONField(name = "name")
	private String fullName;

	@JSONField(name = "birthday",format = "yyyy-MM-dd")
	private Date dateOfBirth;

	private StudyCourse studyCourse;


}
