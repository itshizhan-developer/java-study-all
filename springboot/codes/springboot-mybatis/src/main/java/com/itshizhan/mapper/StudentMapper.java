package com.itshizhan.mapper;

import com.itshizhan.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by leeson8888 on 2018/10/28.
 */
@Repository
public interface StudentMapper {

	@Select("select stu_name as stuName,stu_sex as sex, age  From student where id =#{id}")
	Student findStudentById(Integer id);


	List<Student> findAllStudents();

}
