package com.itshizhan;


import com.itshizhan.beans.Employee;
import com.itshizhan.dao.EmployeeMapper;
import com.itshizhan.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

  private SqlSession sqlSession;

  @Before
  public void beforeLoadXML() throws IOException {
    /*
    //加载 mybatis 配置文件
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //构建sqlSession的工厂
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //根据 sqlSessionFactory 产生 sqlSession
    sqlSession = sqlSessionFactory.openSession();
    */
    sqlSession = SqlSessionFactoryUtil.openSqlSession();

  }



  @Test
  public void mybatisTest1() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
      Employee employee = employeeMapper.selectEmpoyeeById(10);

      System.out.println(employee.getEmail());
    } finally {
      sqlSession.close();
    }
  }


  @Test
  public void mybatisTest2() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

      Employee employee = new Employee();
      employee.setLastName("John");
      employee.setGender("1");
      employee.setEmail("John@163.com");

      employeeMapper.insertEmployee(employee);
      sqlSession.commit(); // 务必，否则不会执行

    } finally {
      sqlSession.close();
    }
  }

//  updateEmployee

  @Test
  public void mybatisTest3() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

      Employee employee = new Employee();
      employee.setId(10);
      employee.setLastName("Jack100");
      employee.setGender("1");
      employee.setEmail("Jack100@163.com");

      employeeMapper.updateEmployee(employee);
      sqlSession.commit(); // 务必，否则不会执行

    } finally {
      sqlSession.close();
    }
  }

  //deleteEmployById
  @Test
  public void mybatisTest4() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
      employeeMapper.deleteEmployById(8);
      sqlSession.commit(); // 务必，否则不会执行

    } finally {
      sqlSession.close();
    }
  }

  @Test
  public void mybatisTest5() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

      Employee employee = new Employee();
      employee.setLastName("John100");
      employee.setGender("1");
      employee.setEmail("John100@163.com");

      employeeMapper.insertEmployeeGetId(employee);
      sqlSession.commit(); // 务必，否则不会执行
      System.out.println(employee.getId());

    } finally {
      sqlSession.close();
    }
  }

  // insertEmployeeGetIdTwo

  @Test
  public void mybatisTest6() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

      Employee employee = new Employee();
      employee.setLastName("John1000");
      employee.setGender("1");
      employee.setEmail("John1000@163.com");

      employeeMapper.insertEmployeeGetIdTwo(employee);
      sqlSession.commit(); // 务必，否则不会执行
      System.out.println(employee.getId());

    } finally {
      sqlSession.close();
    }
  }



}
