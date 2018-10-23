/**
 * Created by leeson8888 on 2018/10/23.
 */
package com.itshizhan;


import com.itshizhan.beans.Student;
import com.itshizhan.dao.StudentMapper;
import com.itshizhan.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppTest2 {

	private SqlSession sqlSession;

	@Before
	public void beforeLoadXML() throws IOException {

		sqlSession = SqlSessionFactoryUtil.openSqlSession();

	}


	@Test
	public void selectStudentById() throws IOException {

		try {
			//使用接口 getMapper
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			Student student = studentMapper.selectStudentById(10);

			System.out.println("----------------------select result------------------");
			System.out.println(student);
			System.out.println("----------------------select result------------------");
		} finally {
			sqlSession.close();
		}
	}

	//getStudentListLikeName

	@Test
	public void getStudentListLikeName() throws IOException {

		try {
			//使用接口 getMapper
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

			Student student = new Student();
			student.setStuName("学生");

			List<Student>  students = studentMapper.getStudentListLikeName(student);


			System.out.println("----------------------select result------------------");
			System.out.println(students);
			System.out.println("----------------------select result------------------");
		} finally {
			sqlSession.close();
		}
	}

	//getStudentListWhereEntity
	@Test
	public void getStudentListWhereEntity() throws IOException {

		try {
			//使用接口 getMapper
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

			Student student = new Student();
			student.setStuSex("男");
			student.setStuName("学生");

			List<Student>  students = studentMapper.getStudentListWhereEntity(student);

			System.out.println("----------------------select result------------------");
			System.out.println(students);
			System.out.println("----------------------select result------------------");

		} finally {
			sqlSession.close();
		}

	}

	//getStudentWithTrim
	@Test
	public void getStudentWithTrim() throws IOException {

		try {
			//使用接口 getMapper
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

			Student student = new Student();
			student.setStuSex("男");
			//student.setStuName("学生");

			List<Student>  students = studentMapper.getStudentWithTrim(student);

			System.out.println("----------------------select result------------------");
			System.out.println(students);
			System.out.println("----------------------select result------------------");

		} finally {
			sqlSession.close();
		}

	}


	//getStudentListWithForEach
	@Test
	public void getStudentListWithForEach() throws IOException {

		try {
			//使用接口 getMapper
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

//			Student student = new Student();
//			student.setStuSex("男");
			//student.setStuName("学生");

			List<Integer> ageList = new ArrayList<>();
			ageList.add(20);
			//ageList.add(23);
			ageList.add(30);

			List<Student>  students = studentMapper.getStudentListWithForEach(ageList);

			System.out.println("----------------------select result------------------");
			System.out.println(students);
			System.out.println("----------------------select result------------------");

		} finally {
			sqlSession.close();
		}

	}


}
