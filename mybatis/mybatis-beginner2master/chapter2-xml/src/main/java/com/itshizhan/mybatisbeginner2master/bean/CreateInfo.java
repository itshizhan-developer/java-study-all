package com.itshizhan.mybatisbeginner2master.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建人信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInfo implements Serializable {

	private static final long serialVersionUID = 8275281589408844992L;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;


}
