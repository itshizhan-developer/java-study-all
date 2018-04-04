# 一、myBatis 的基本构成

## myBatis 核心组件
- SqlSessionFactoryBuilder（构造器）：根据全局配置信息或代码生成SqlSessionFactory(工厂接口)；
- SqlSessionFactory：依靠工厂来生成SqlSession 会话。
- SqlSession：既可以发送Sql去执行并返回结果，也可以获取Mapper的接口。
- SQL Mapper：由java接口和xml文件(或注解)构成的组件，给出对于的sql和映射规则，负责发送sql去执行，并返回结果。

### SqlSessionFactory


### SqlSession



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
 

# 二、myBatis配置

# 三、myBatis映射器

# 四、动态Sql

# 五、myBatis运行原理

# 六、与spring的整合

# 七、常用应用实例