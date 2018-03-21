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
