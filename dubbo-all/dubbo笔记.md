# dubbo 官方demo报的傻逼错误

1、provider 启动报错：Unsupported server type: netty

原因：pom依赖的是 netty4, 配置里面没有写

```
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-remoting-netty4</artifactId>
</dependency>
```

解决方案：

```
<dubbo:protocol name="dubbo" port="20880" server="netty4"/>
```



**启动OK**



2、comsumer启动报错：Unsupported client type: netty, supported client type is netty4

但是，没有看到任何可以修改server的地方。



**3、 终极方案：**

provider配置文件添加：

```
<dubbo:provider server="netty4"/>
```

comsumer配置文件添加：

```
<dubbo:consumer client="netty4" />
```

