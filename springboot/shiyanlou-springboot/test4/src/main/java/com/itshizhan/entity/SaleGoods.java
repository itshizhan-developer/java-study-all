package com.itshizhan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleGoods {
	private Integer id;
	private String goodsName;
	private float weight;
	private int type;
	private Boolean onSale;
}
