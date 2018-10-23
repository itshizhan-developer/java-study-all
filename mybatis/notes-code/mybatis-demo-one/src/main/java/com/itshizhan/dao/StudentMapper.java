/**
 * Created by leeson8888 on 2018/10/23.
 */
package com.itshizhan.dao;

import com.itshizhan.beans.Student;

import java.util.List;

public interface StudentMapper {

	Student selectStudentById(Integer id);

	List<Student> getStudentListLikeName(Student student);

	List<Student> getStudentListWhereEntity(Student student);

	//getStudentWithTrim
	List<Student> getStudentWithTrim(Student student);

	//getStudentListWithForEach
	List<Student> getStudentListWithForEach(List<Integer> ageList);



}
