# 一、myBatis 的基本构成

### myBatis 核心组件
- SqlSessionFactoryBuilder（构造器）：根据全局配置信息或代码生成SqlSessionFactory(工厂接口)；
- SqlSessionFactory：依靠工厂来生成SqlSession 会话。
- SqlSession：既可以发送Sql去执行并返回结果，也可以获取Mapper的接口。
- SQL Mapper：由java接口和xml文件(或注解)构成的组件，给出对于的sql和映射规则，负责发送sql去执行，并返回结果。

# 二、myBatis 配置

# 三、myBatis 映射器

# 四、动态Sql

# 五、myBatis 运行原理

# 六、与spring 的整合

# 七、常用应用实例