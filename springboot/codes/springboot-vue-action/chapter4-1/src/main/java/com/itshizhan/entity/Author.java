/**
 * Created by leeson8888 on 2019/2/27.
 */
package com.itshizhan.entity;

public class Author {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Author{" +
						"name='" + name + '\'' +
						", age=" + age +
						'}';
	}
}
