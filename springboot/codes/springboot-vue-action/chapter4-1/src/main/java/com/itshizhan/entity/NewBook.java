/**
 * Created by leeson8888 on 2019/2/27.
 */
package com.itshizhan.entity;

public class NewBook {
	private String name;
	private Integer price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NewBook{" +
						"name='" + name + '\'' +
						", price=" + price +
						'}';
	}
}
