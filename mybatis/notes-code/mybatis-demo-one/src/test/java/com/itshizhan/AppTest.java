package com.itshizhan;


import com.itshizhan.beans.Employee;
import com.itshizhan.dao.EmployeeMapper;
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

  private SqlSession session;

  @Before
  public void beforeLoadXML() throws IOException {
    //加载 mybatis 配置文件
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //构建sqlSession的工厂
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //根据 sqlSessionFactory 产生 session
    session = sqlSessionFactory.openSession();
  }


  @Test
  public void mybatisTest1() throws IOException {

    try {
      //通过 SqlSession 实例来直接执行已映射的 SQL 语句
      Employee employee = (Employee) session.selectOne("selectEmployee", 2);
      System.out.println(employee);
    } finally {
      session.close();
    }
  }

  @Test
  public void mybatisTest2() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
      Employee employee = employeeMapper.selectEmpoyeeById(2);

      System.out.println(employee.getEmail());
    } finally {
      session.close();
    }
  }

  @Test
  public void mybatisTest3() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
      Employee emp = new Employee();
      emp.setLastName("jack");
      emp.setGender("1");
      emp.setEmail("jack@163.com");

      int count = employeeMapper.insertEmployee(emp);
      session.commit();//这里一定要提交，不然数据进不去数据库中
      System.out.println(count);

    } finally {
      session.close();
    }

  }

  @Test
  public void mybatisTest4() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

      List emps = employeeMapper.selectEmployeeLikeName("1","%m%");

      System.out.println(emps);

    } finally {
      session.close();
    }
  }

  @Test
  public void mybatisTest5() throws IOException {

    try {
      //使用接口 getMapper
      EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

      List emps = employeeMapper.selectEmployeeLikeNamePlus("1");

      System.out.println(emps);

    } finally {
      session.close();
    }
  }



}
