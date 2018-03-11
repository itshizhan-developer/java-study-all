/**
 * Created by leeson8888 on 2018/3/7.
 */
package com.itshizhan.beans;

public class Person {
  private String name;
  private Integer age;
  private String gender;
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

  public  Person(){

  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Person(String name, Integer age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            '}';
  }
}
