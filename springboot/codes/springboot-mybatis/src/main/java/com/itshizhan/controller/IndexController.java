/**
 * Created by leeson8888 on 2018/10/28.
 */
package com.itshizhan.controller;

import com.itshizhan.entity.Student;
import com.itshizhan.service.StudentService;
import com.itshizhan.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {



	@Autowired
	StudentService studentService;


	@RequestMapping("/index")
	public String index(){
		return "hello mybatis";
	}

	@RequestMapping("/findStuddentById")
	public String  findStuddentById(@RequestParam(value = "id",required = false) Integer id){

		Student student = studentService.findStudentById(id);
		String age = student.getAge()+"";
		return "姓名："+ student.getStuName() + ",性别：" + student.getSex() + ",年龄："+age;

	}


	@RequestMapping("/findAllStudent")
	public List<Student> findAllStudents(){

		List<Student> students = studentService.findAllStudents();

		System.out.println(students);

		return  students;

	}

}
