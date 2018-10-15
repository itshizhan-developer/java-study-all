提示： 
完整的代码及demo地址：https://github.com/itshizhan/java_study_notes/tree/master/mybatis/notes-code/

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
			 3. select 的id 名称 `selectEmpoyeeById` 与 `com.itshizhan.dao.EmployeeMapper` 接口的 selectEmpoyeeById 方法名称一致。

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
​```

## myBatis 生命周期

#### SqlSessionFactoryBuilder

利用SqlSessionFactoryBuilder 可以构建多个 SqlSessionFactory ，其作用就是一个构建器，一旦构建完 SqlSessionFactory，其作用就已结束，应将其回收。**因此，其生命周期只存在于方法的局部**，其作用就是生成 SqlSessionFactory 对象。

#### SqlSessionFactory

SqlSessionFactory 的作用是创建 SqlSession，而 SqlSession 相对于一个回话，即JDBC中的 Connection 对象。应用程序每次访问数据库，都需要通过 SqlSessionFactory 创建 SqlSession ，**因此 SqlSessionFactory 的生命周期存在于整个应用**。 为了避免每次创建 SqlSession 对象，都会创建一个新的连接，应采用**单例的方式** ， 以避免过多的 Connection 消耗。

#### SqlSession

之前说过， SqlSession 是一个会话，相对于一个 Connection 对象。**其生命周期应该是每次请求数据库处理事务的过程中**。 **SqlSession 是一个线程不安全的对象**。 同时，应该每次请求处理完毕，及时进行关闭。 	

#### Mapper

Mapper 是一个接口，其作用是发出Sql，还回需要的结果，或修改数据库数据，**其生命周期应该在一个SqlSession 事务方法之内**，属于方法级别的东西。

## 实战： 通过单例构建SqlSession 对象: SqlSessionFactoryUtil.java

​```java
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
- 在properties 元素体内指定的属性首先读取（`优先级最低`）
- 根据properties 元素的resource 属性读取类路径下的属性文件，或者根据url属性指定的路径读取属性文件，并覆盖已经读取的同名属性。
- 读取方法参数传递的属性，并覆盖已经读取的同名属性（`优先级最高`）

## 设置 setting：

settings 是myBatis中非常重要的调整设置，可以改变myBatis运行时的行为，如缓存，开启驼峰命名规则等

常用的设置有：
  - useGeneratedKeys：自动生成主键
  - defaultStatementTimeout：设置超时时间，决定驱动等待数据库响应的秒数
  - mapUnderscoreToCamelCase：开启驼峰，即从经典数据库列名A_Column 到经典java数项目aColumn的映射

例如：

```xml
  <settings>
    <setting name="mapUnderscoreToCamelCase" value="true"/>
  </settings>
```


## typeAliases 别名：

- 分为：系统定义别名 和 自定义别名。别名不区分大小写。
- typeAliases的实例是在解析配置文件时生成的，然后长期保存在Congfiguration 对象中。

#### 系统定义别名
主要是针对数值、字符串、日期和集合等。

例如：
- _byte  ---> byte 类型的别名
- _int   ---> int 类型的别名
- int    ---> Integer 类型的别名
- byte   ---> Byte 类型的别名
- data   --->  Date 类型的别名
- map    ---> Map 类型的别名
- hashmap ---> HashMap 类型的别名
- list   ---> List 类型的别名
- collection ---> Collection 类型的别名
- arraylist  ---> ArrayList 类型的别名

详细的系统定义别名可以参加官方文档。

对于支持数组类型的只有加[] 即可，例如Date数组别名可以用data[] 代替。


#### 自定义别名

1）单个自定义别名的配置

```xml
<!-- 例如 在全局配置文件中配置后，即可在Mybatis上下文使用 employee 别名 -->
<typeAliases>
    <typeAlias alias="employee" type="com.itshizhan.beans.Employee"></typeAlias>
</typeAliases>
```

2）自动扫描包自定义别名
```xml
<!-- 
1：配置自动扫描的报名
2：使用@Alias("employee") 注解自动装载。如果没有使用注解，则使用类名 的首字母小写的名称作为名别。
 -->
<typeAliases>
  <package name="com.itshizhan.beans">
</typeAliases>
```

## typeHandler 类型处理器

MyBatis 在预处理语句（PreparedStatement）中设置一个参数时，或者从结果集(ResultSet) 中取出一个值时，都会用注册了的typeHandler 进行处理。

和别名一样，typeHandler也分为 系统定义和用户自定义两种。

typeHandler 常用的配置为Java类型(javaType)、JDBC类型(jdbcType)，typeHandler 的作用就是讲参数从javaType 转化为jdbcType，或从数据库取出结果时，把jdbcType 转化为javaType。

#### 系统定义的typeHandler:

如：StringTypeHandler，IntegerTypeHandler 等，直接使用即可。具体参见官方文档。

#### 自定义typeHandler：



## ObjectFactory


## 插件

## Environments 环境配置

## databaseIdProvider 数据库厂商标识

## 映射器配置



# 三、myBatis映射器


## myBatis参数处理

1）单个参数
对于单个参数mybatis不做特殊处理，只需要用  #{任意参数名} 取出参数值就可以了。例如:

```java
// 接口
Employee selectEmpoyeeById(Integer id);
```

```xml
<!-- 映射器语句 -->
<select id="selectEmpoyeeById" parameterType="int"  resultType="employee">
  SELECT * FROM t_employee 
  WHERE 
  id = #{xyz}
</select>
```

2）多个参数

接口：
```java
  // 多个参数：根据部门id和性别查询员工,可能多个，所有返回list
  List<Employee> selectEmpoyeeByDidAndGender(Integer did,String gender);
```
sql语句：

```xml
<select id="selectEmpoyeeByDidAndGender"  resultType="employee">
    SELECT * FROM t_employee
    WHERE
    did = #{did}
    AND
    gender = #{gender}
</select>
```
结果报错：
> `Caused by: org.apache.ibatis.binding.BindingException: Parameter 'did' not found. Available parameters are [arg1, arg0, param1, param2]`

即可以使用的参数必须是 [arg1, arg0, param1, param2]

#### 处理方式之一：

使用参数param1，param2，param3，……

```xml
<!-- 
  实际上，在myBatis内部，多个参数被封装为一个map，map 的key值为：param1，param2，param3，……
 -->
<select id="selectEmpoyeeByDidAndGender"  resultType="employee">
    SELECT * FROM t_employee
    WHERE
    did = #{param1}
    AND
    gender = #{param2}
</select>

<!-- 
或则使用map索引
注意： 在mybatis 3.4 之前，索引可以使用 0，1，但是，
从mybatis 3.4.4 开始，多参数传递必须是  [arg1, arg0, param1, param2]， 不能是 #{0}，#{1} 了
 -->

<select id="selectEmpoyeeByDidAndGender"  resultType="employee">
    SELECT * FROM t_employee
    WHERE
    did = #{arg0}
    AND
    gender = #{arg1}
</select>
```

#### 处理方式之二：命名参数

由于，params1 ，params2不够语义化，可以使用命名参数，例如：

接口：
```java
// 多个参数：根据部门id和性别查询员工
List<Employee> selectEmpoyeeByDidAndGenderPlus(@Param("did") Integer did, @Param("gender") String gender);
```

sql语句:

```xml
<!-- 
通过@param("key")明确指定封装map中的key，就可以通过#{key}取出参数值了
 -->
<select id="selectEmpoyeeByDidAndGenderPlus"  resultType="employee">
    SELECT * FROM t_employee
    WHERE
    did = #{did}
    AND
    gender = #{gender}
</select>
```

#### 处理方式之三：直接使用map传参（底层实现）

接口：
```java
  // 多个参数封装为map
  List<Employee> selectEmpoyeeByMap(Map<String,Object> map);
```

sql语句：
```xml
<!-- 多个参数：封装为map
通过map.put(key,value) 的key 取出 #{key} 参数
-->

<select id="selectEmpoyeeByMap"  resultType="employee">
    SELECT * FROM t_employee
    WHERE
    did = #{did}
    AND
    gender = #{gender}
</select>
```

测试代码：
```java
@Test
public void mybatisTestByMap() throws IOException {

  try {
    //使用接口 getMapper
    EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

    Map map =new HashMap<>();
    map.put("did",108);
    map.put("gender","1");

    List<Employee> employeeList = employeeMapper.selectEmpoyeeByMap(map);
    System.out.println(employeeList);

  } finally {
    sqlSession.close();
  }
}
```


# 四、动态Sql

# 五、myBatis运行原理

# 六、与spring的整合

# 七、常用应用实例