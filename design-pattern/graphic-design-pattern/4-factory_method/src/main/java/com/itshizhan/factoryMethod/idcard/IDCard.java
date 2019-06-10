package com.itshizhan.factoryMethod.idcard;

import com.itshizhan.factoryMethod.framework.Product;

public  class IDCard extends Product {
	private String owner;

	public IDCard(String owner) {
		System.out.println("制作" + owner + "的ID卡");
		this.owner = owner;
	}


	public void  use(){
		System.out.println("使用" + owner + "的ID卡");
	}

	public String getOwner(){
		return owner;
	}
}
