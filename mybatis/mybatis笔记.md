# 一、myBatis 的基本构成

## myBatis 核心组件
- SqlSessionFactoryBuilder（构造器）：根据全局配置信息或代码生成SqlSessionFactory(工厂接口)；
- SqlSessionFactory：依靠工厂来生成SqlSession 会话。
- SqlSession：既可以发送Sql去执行并返回结果，也可以获取Mapper的接口。
- SQL Mapper：由java接口和xml文件(或注解)构成的组件，给出对于的sql和映射规则，负责发送sql去执行，并返回结果。

### SqlSessionFactory

每个mybatis应用程序都是以SqlSessionFactory的实例为中心的。SqlSessionFactory的实例可以通过SqlSessionFactoryBuilder（构造器） 获得。 SqlSessionFactory 是一个工厂接口，而不是实现类。

### SqlSession

SqlSession 是一个接口类。其实现类有两个，分别是：DefaultSqlSession 和 SqlSessionManager 。
SqlSession 的作用主要有：
1）获取映射器mapper。让映射器通过命名空间和方法找到对应的sql并执行。
2）执行通过命名信息（如update，insert，select，delete）去执行sql。 这是iBatis遗留的使用方式。


### 映射器
由java接口和xml文件(或注解)构成的组件。主要作用：
- 定义参数类型
- 描述缓存
- 描述SQL语句
- 定义查询结果与POJO的映射关系。

映射器实现的两种方式：
1. xml 文件实现，由全局配置文件加载（**推荐**）
2. 通过代码实现以注解的方式实现 （**iBatis方式，不推荐**）

#### xml 文件实现
1）定义一个接口 : EmployeeMapper.java

```java
package com.itshizhan.dao;
import com.itshizhan.beans.Employee;
public interface EmployeeMapper {
   Employee selectEmpoyeeById(Integer id);
}
```
2) 给出一个映射xml文件: EmployeeMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.itshizhan.dao.EmployeeMapper">
    <select id="selectEmpoyeeById" resultType="employee">
        select * from t_employee where id = #{id}
    </select>
</mapper>
```
> 注意：1. 接口文件名和xml 文件名相同。
			 2. 命名空间名称 `com.itshizhan.dao.EmployeeMapper` 同接口全限定名 `com.itshizhan.dao.EmployeeMapper` 名称一致.
			 3. select 的id 名称 `selectEmployee` 与 `com.itshizhan.dao.EmployeeMapper` 接口的 selectEmpoyeeById 方法名称一致。


3）通过sqlSession 获取映射器mapper

```java
 // 获取映射器mapper
 EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
 // 执行接口方法
 Employee employee = employeeMapper.selectEmpoyeeById(1);
```


#### java 注解实现mapper

直接在接口方法上使用注解：EmployeeMapper.java

```java
package com.itshizhan.dao;
import com.itshizhan.beans.Employee;
public interface EmployeeMapper {
	@Select(value="select * from t_employee where id = #{id}")  
  Employee selectEmpoyeeById(Integer id);
}
````
## myBatis 生命周期

#### SqlSessionFactoryBuilder

利用SqlSessionFactoryBuilder 可以构建多个 SqlSessionFactory ，其作用就是一个构建器，一旦构建完 SqlSessionFactory，其作用就已结束，应将其回收。**因此，其生命周期只存在于方法的局部**，其作用就是生成 SqlSessionFactory 对象。

#### SqlSessionFactory

SqlSessionFactory 的作用是创建 SqlSession，而 SqlSession 相对于一个回话，即JDBC中的 Connection 对象。应用程序每次访问数据库，都需要通过 SqlSessionFactory 创建 SqlSession ，** 因此 SqlSessionFactory 的声明周期存在于整个应用**。 为了避免每次创建 SqlSession 对象，都会创建一个新的连接，应采用**单例的方式** ， 以避免过多的 Connection 消耗。

#### SqlSession

之前说过， SqlSession 是一个会话，相对于一个 Connection 对象。**其生命周期应该是每次请求数据库处理事务的过程中**。 **SqlSession 是一个线程不安全的对象**。 同时，应该每次请求处理完毕，及时进行关闭。 	

#### Mapper

Mapper 是一个接口，其作用是发出Sql，还回需要的结果，或修改数据库数据，**其生命周期应该在一个SqlSession 事务方法之内**，属于方法级别的东西。

## 实战： 通过单例构建SqlSession 对象: SqlSessionFactoryUtil.java
```java
/**
 * Created by itshizhan2016 on 2018/4/5.
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

```

# 二、myBatis配置

### myBatis 全局配置文件层次结构：注意顺序不能错
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration> 
  <properties/> 
  <setting/>
  <typeAliases/>
  <typeHandlers/>
  <objectFactory/>
  <plugins/>
  <environments>
    <environment>
      <transactionManager/>
      <dataSource/>
    </environment>
  </environments>
  <databaseIdProvider/>
  <mappers/>
</configuration>
```
依次是：属性，设置，类型别名，类型处理器，对象工厂，插件，配置环境（事务管理器，数据源），数据库厂商标识，映射器

##  属性properties：
mybatis 针对属性，提供了3中配置方式：
- property 子元素
- properties 配置文件
- 程序参数传递

1）property 子元素方式：

```xml
<properties>
  <property name="driver" value="com.mysql.jdbc.Driver"/>
  <property name="url" value="jdbc:mysql://localhost:3306/mybatis_demo"/>
  <property name="username" value="root"/>
  <property name="password" value="root123"/>
</properties>
```
通过property 子元素配置好属性后，就可以在上下文中使用以及配置好的属性，例如：

```xml
<environments default="development">
    <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
          <property name="driver" value="${driver}"/>
          <property name="url" value="${url}"/>
          <property name="username" value="${username}"/>
          <property name="password" value="${password}"/>
        </dataSource>
    </environment>
</environments>
```

2) 使用配置文件配置属性，例如：db.properties

```js
#数据库配置文件
driver = com.mysql.jdbc.Driver
url = jdbc:mysql://localhost:3306/mybatis_demo
username = root
password = root123
```

在mybatis 全局配置文件中引入properties.db

```xml
<properties resource="db.properties"/>
```

3) 通过程序参数传递属性

```java
Properties properties = new Properties();
properties.load(inputStream); // inputStream为读取的属性配置文件流
properties.setProperty("username");
// 省略部分代码
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfgReader,properties)/
```
仅供了解，具体可以参见如果使用代码的方式创建SqlSessionFactory对象。

#### 各种属性配置方式的优先级：



# 三、myBatis映射器

# 四、动态Sql

# 五、myBatis运行原理

# 六、与spring的整合

# 七、常用应用实例