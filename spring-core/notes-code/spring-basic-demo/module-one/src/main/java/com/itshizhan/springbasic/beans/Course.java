/**
 * Created by leeson8888 on 2018/10/21.
 */
package com.itshizhan.springbasic.beans;

public class Course {
	private  String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course{" +
						"name='" + name + '\'' +
						'}';
	}
}
