package com.itshizhan.service;

import com.itshizhan.entity.Student;

import java.util.List;

/**
 * Created by leeson8888 on 2018/10/28.
 */

public interface StudentService {

	 Student findStudentById(Integer id);

	 List<Student> findAllStudents();
}
