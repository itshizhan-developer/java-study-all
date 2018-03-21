# Mapper XML 文件

sql 映射文件的顶级元素并不多，主要有：

- cache: 给约定命名空间的缓存配置
- cache-ref: 其他命名空间对缓存配置的引用
- resultMap: sql映射文件最强大的元素，用来描述如何从数据库结果集中加载对象。
- sql: 可以被其他语句重复引用的语句块。
- insert：映射插入语句
- update：映射更新语句
- delete：映射删除语句
- select：映射查询语句


# select 最常用的查询语句

最简单的查询语句
```xml
<select id="selectEmpoyeeById" parameterType="int" resultType="employee">
  SELECT * FROM PERSON WHERE ID = #{id}
</select>
```


# sql

可以被用来定义可重用的 SQL 代码段，可以包含在其他语句中。可以被静态地(在加载参数) 参数化. 不同的属性值通过包含的实例变化。

例如：

```xml
<sql id="userColumns"> ${alias}.id,${alias}.username,${alias}.password </sql>
```

这个 SQL 片段可以被包含在其他语句中，例如：

```xml

<select id="selectUsers" resultType="map">
  select
    <include refid="userColumns"><property name="alias" value="t1"/></include>,
    <include refid="userColumns"><property name="alias" value="t2"/></include>
  from some_table t1
    cross join some_table t2
</select>

```

属性值也可以被用在 include 元素的 refid 属性里,或 include 内部语句中

例如：

#  参数（Parameters）字符串替换

默认情况下,使用 #{} 格式的语法会导致 MyBatis 创建 PreparedStatement 参数并安全地设置参数（就像使用 ? 一样）。这样做更安全，更迅速，通常也是首选做法，不过有时你就是想直接在 SQL 语句中插入一个不转义的字符串。
比如，像 ORDER BY，你可以这样来使用：

``` 
RDER BY ${columnName}
```
这里 MyBatis 不会修改或转义字符串。



#  ResultMaps 返回结果集

resultType 通常适合简单的结果集映射，如基本类型，map等，
如果要将结果集映射到JavaBean 或 POJO(Plain Old Java Objects，普通 Java 对象)。使用resultmap更加方便。

例如：

```xml
<resultMap id="userResultMap" type="User">
  <id property="id" column="user_id" />
  <result property="username" column="user_name"/>
  <result property="password" column="hashed_password"/>
</resultMap>
```
在下列语句中引用 resultMap 的Id属性（`userResultMap`）即可。
```xml
<select id="selectUsers" resultMap="userResultMap">
  select user_id, user_name, hashed_password
  from some_table
  where id = #{id}
</select>
```

### resultMap 的子元素

1. constructor - 用于在实例化类时，注入结果到构造方法中

- idArg - ID 参数;标记出作为 ID 的结果可以帮助提高整体性能
- arg - 将被注入到构造方法的一个普通结果

2. id – 一个 ID 结果;标记出作为 ID 的结果可以帮助提高整体性能

3. result – 注入到字段或 JavaBean 属性的普通结果

4. association – 一个复杂类型的关联;许多结果将包装成这种类型
- 嵌套结果映射 – 关联可以指定为一个 resultMap 元素，或者引用一个
5. collection – 一个复杂类型的集合
- 嵌套结果映射 – 集合可以指定为一个 resultMap 元素，或者引用一个
6. discriminator – 使用结果值来决定使用哪个 resultMap
- case – 基于某些值的结果映射

### id & result

这些是结果映射最基本的内容。id 和 result 都将一个列的值映射到一个简单数据类型(字符串,整型,双精度浮点数,日期等)的属性或字段。

这两者之间的唯一不同是， id 表示的结果将是对象的标识属性，这会在比较对象实例时用到。
 
这样可以提高整体的性能，尤其是缓存和嵌套结果映射(也就是联合映射)的时候。

### id & result 都具备的属性
1. property：映射到列结果的字段或属性。如果用来匹配的 JavaBeans 存在给定名字的属性，那么它将会被使用。
						否则 MyBatis 将会寻找给定名称 property 的字段。 无论是哪一种情形，你都可以使用通常的点式分隔形式进行复杂属性导航。
						比如,你可以这样映射一些简单的东西: “username” ,或者映射到一些复杂的东西: “address.street.number” 。
2. column：数据库中的列名,或者是列的别名。一般情况下，这和 传递给 resultSet.getString(columnName) 方法的参数一样。
3. javaType	一个 Java 类的完全限定名,或一个类型别名(参考上面内建类型别名 的列表) 。如果你映射到一个 JavaBean,MyBatis 通常可以断定类型。 然而,如果你映射到的是 HashMap,那么你应该明确地指定 javaType 来保证期望的行为。
4. jdbcType	JDBC 类型，所支持的 JDBC 类型参见这个表格之后的“支持的 JDBC 类型”。 只需要在可能执行插入、更新和删除的允许空值的列上指定 JDBC 类型。这是 JDBC 的要求而非 MyBatis 的要求。如果你直接面向 JDBC 编程,你需要对可能为 null 的值指定这个类型。
5. typeHandler	我们在前面讨论过的默认类型处理器。使用这个属性,你可以覆盖默 认的类型处理器。这个属性值是一个类型处理 器实现类的完全限定名，或者是类型别名。