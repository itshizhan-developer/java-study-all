package com.itshizhan;

import static org.junit.Assert.assertTrue;

import com.itshizhan.dao.CountryMapper;
import com.itshizhan.dao.UserMapper;
import com.itshizhan.model.Country;
import com.itshizhan.model.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
{


    private static SqlSessionFactory sqlSessionFactory;

    @Before
    public  void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);

            List<Country> countryList = countryMapper.getAllCountry();

            printCountryList(countryList);
        } finally {
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList){
        for(Country country : countryList){
            System.out.printf("%-4d%4s%4s\n",country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }

    @Test
    public void selectUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser sysUser = userMapper.selectUserById(1001L);

            System.out.println(sysUser);

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectAllUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<SysUser> userList= userMapper.selectAllUser();

            System.out.println(userList);



        } finally {
            sqlSession.close();
        }
    }
}
