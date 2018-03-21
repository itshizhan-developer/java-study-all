package com.itshizhan;


import com.itshizhan.beans.Employee;
import com.itshizhan.mappers.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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


}
