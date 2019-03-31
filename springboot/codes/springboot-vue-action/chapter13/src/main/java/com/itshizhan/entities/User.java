package com.itshizhan.entities;


import com.itshizhan.validations.ValidationGroup1;

import javax.validation.constraints.*;


public class User {

	private Integer id;

	@NotNull(message = "{user.name.notnull}")
	@Size(min = 5, max = 10, message = "{user.name.size}")
	private String name;

	@NotNull(message = "{user.address.notnull}",groups = ValidationGroup1.class)
	private String address;

	@DecimalMin(value = "1",message = "{user.age.size}")
  @DecimalMax(value = "200", message = "{user.age.size}")
	private Integer age;

	@Email(message = "{user.email.pattern}")
	@NotNull(message = "{user.email.notnull}")
	private String email;
	//省略getter/setter


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
