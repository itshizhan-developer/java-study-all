package com.itshizhan;


import com.itshizhan.beans.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void mybatisTest() throws IOException {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      SqlSession session = sqlSessionFactory.openSession();
      try {
        Employee employee = (Employee) session.selectOne("selectEmployee", 1);
        System.out.println(employee);
      } finally {
        session.close();
      }

    }
}
