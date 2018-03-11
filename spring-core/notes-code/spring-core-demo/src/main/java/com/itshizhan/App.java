package com.itshizhan;

import com.itshizhan.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //创建容器对象,classpath:applicationContext.xml 或applicationContext.xml
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //根据容器对象，获取bean
        Person person = (Person) ac.getBean("person1");

        System.out.println(person);


    }
}
