/**
 * Created by leeson8888 on 2018/10/23.
 */
package com.itshizhan.beans;

import java.util.Date;

public class Student {

	// 学生Id
	private Integer id;

	// 学生姓名
	private String stuName;

	// 学生性别
	private String stuSex;
	// 学生生日
	private Date stuBirthday;

	// 学生年龄
	private Integer age;





	public Student() {
	}

	public Student(Integer id, String stuName, String stuSex, Date stuBirthday,Integer age) {
		this.id = id;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuBirthday = stuBirthday;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Date getStuBirthday() {
		return stuBirthday;
	}

	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return '\n' + "Student{" +
						"id=" + id +
						", stuName='" + stuName + '\'' +
						", stuSex=" + stuSex +
						", stuAge=" + age +
						", stuBirthday=" + stuBirthday +
						'}' + '\n';
	}
}
