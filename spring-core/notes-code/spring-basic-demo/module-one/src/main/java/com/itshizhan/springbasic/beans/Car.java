/**
 * Created by leeson8888 on 2018/10/21.
 */
package com.itshizhan.springbasic.beans;

public class Car {
	private String type;
	private String name;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car{" +
						"type='" + type + '\'' +
						", name='" + name + '\'' +
						'}';
	}
}
