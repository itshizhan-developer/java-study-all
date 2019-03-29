package com.itshizhan.entities;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户实体类",description = "用户信息描述类")
public class User {
	@ApiModelProperty("用户Id")
	Integer id;
	@ApiModelProperty("用户名")
	String username;
	@ApiModelProperty("用户地址")
	String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" +
						"id=" + id +
						", username='" + username + '\'' +
						", address='" + address + '\'' +
						'}';
	}
}
