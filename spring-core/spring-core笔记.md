# spring 入门

### spring 环境配置流程
1. maven引入相关依赖

```xml
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
```

2、创建spring 容器的配置文件，在Classpath 路径下创建`applicationContext.xml`配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="person1" class="com.itshizhan.beans.Person">
        <property name="name" value="leeson"></property>
        <property name="age" value="28"></property>
    </bean>
</beans>
```

3、获取spring 容器中配置好的beans

```java
  ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
  Person person = (Person) ac.getBean("person1");
  System.out.println(person);
```

源码：