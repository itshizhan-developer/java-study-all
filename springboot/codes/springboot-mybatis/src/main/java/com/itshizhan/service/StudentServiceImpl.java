/**
 * Created by leeson8888 on 2018/10/28.
 */
package com.itshizhan.service;

import com.itshizhan.entity.Student;
import com.itshizhan.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentServiceImpl  implements StudentService{

	@Autowired
	StudentMapper studentMapper;

	public Student findStudentById(Integer id){
		return  studentMapper.findStudentById(id);
	}

	@Override
	public List<Student> findAllStudents() {
		return studentMapper.findAllStudents();
	}
}
