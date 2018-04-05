/**
 * Created by leeson8888 on 2018/4/5.
 */
package com.itshizhan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlSessionFactoryUtil {
  //SqlSessionFactory 对象
  private static SqlSessionFactory sqlSessionFactory = null;

  //类线程锁
  private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

  //私有化构造函数
  private  SqlSessionFactoryUtil(){}

  //构建SQLSessionFactory
  public static SqlSessionFactory initSqlSessionFactory(){

    //加载 mybatis 配置文件
    String resource = "mybatis-config.xml";
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
      Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE,null,e);
    }

    synchronized (CLASS_LOCK){
      if(sqlSessionFactory == null){
        //构建sqlSession的工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      }
    }

    return sqlSessionFactory;

  }

  //打开 SqlSession
  public static SqlSession openSqlSession(){
    if(sqlSessionFactory == null){
      initSqlSessionFactory();
    }
    return sqlSessionFactory.openSession();
  }

}
