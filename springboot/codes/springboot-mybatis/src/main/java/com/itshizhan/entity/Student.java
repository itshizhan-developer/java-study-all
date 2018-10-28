/**
 * Created by leeson8888 on 2018/10/28.
 */
package com.itshizhan.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
	private Integer id;
	private String  stuName;
	private String  sex;
	private Date birthday;
	private Integer age;

}
