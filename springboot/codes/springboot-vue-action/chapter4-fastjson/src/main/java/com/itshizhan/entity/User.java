package com.itshizhan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	private String name;
	//@JSONField(serialize = false)
	private Integer age;
	private transient String password;

}
