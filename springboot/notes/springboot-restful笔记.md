# maven 运行springboot 项目

 在springboot项目目录运行：`mvn spring-boot:run`



# 1. Demo1 知识点

### 1.1 spring boot 格式化日期

application.properties

```properties
spring.jackson.date-format=yyyy-MM-dd
spring.jackson.time-zone=GMT+8
```



### 1.2 JAVA中时间类Date、SimpleDateFormat、Calendar的用法

- Date表示的是时间点，提供的long getTime()和setTime()方法分别用于获取时间毫秒数和设置Date类型对象的时间。Date 的每一个实例都可以表示一个确切的时间点，其内部维护了一个long类型的值，这个值所表示的是UTC时间（1970年1月1日 00：00：00）到当前时间点的毫秒数。

- SimpleDateFormat用于将时间转换成指定的格式，提供的String format()和Date parse()方法用于Date类型和String类型之间的转换。

- Calendar表示的日历，用于操作时间。其提供的Date getTime()和void setTime()方法用于Calendar与Date之间的转换，同时还提供了set和get方法，用于设置和获取当前的Calendar所表示的时间。

#### 1.2.1 Date 用法举例

```java
/*****
* 求出明天这个时间点的时间日期
*/

//获取当前时间日期
Date d1 = new Date();
//将当前时间日期转为long类型的时间毫秒数
long t1 = d1.getTime();
//加上24小时的毫秒数
t1 += 1000*60*60*24;
//将明天的时间毫秒数转为Date
d1.setTime(t1);//第一种方法，直接设置
System.out.println(d1);
Date d2 = new Date(t1);//第二种方法重新创建新的Date类型的对象用于接收
System.out.println(d2);
```



#### 1.2.2 **SimpleDateFormat** 的日期表示格式

y 表示年 yyyy

M 表示月 MM

d 表示日 dd

H 表示时（24小时制）HH

h 表示时（12）小时制  hh

m 表示分 mm

s 表示秒  ss

a 表示上/下午 

E 表示周几



**format(Date date):**  将给定的Date表示的时间按照SimpleDateFormat 描述的格式转为字符串。

**parse(String str): **按照SimpleDateFormat 描述的格式将给定的字符串解析为Date对象。

**用法具体：**

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss a");
Date date = new Date();

String time = sdf.format(date);
System.out.println(time); //2018-09-10 Mon 02:13:11 AM

SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
String str = "2008/08/08 20:08:08";
Date date1 = sdf1.parse(str);// Fri Aug 08 20:08:08 CST 2008
System.out.println(date1);
```



#### 1.2.3 **Calendar** 是一个抽象类 

不能被实例化，所以Calendar类内部给我们提供了一个静态方法getInstance() 用于获取实例。

**Calendar中也给我们提供了setTime()和getTime()方法，但与Date类中不一样的是，此处的这两个方法是用来将Calendar与Date进行转换的**

```java
//实例化Calendar，得到的默认就是当前系统时间
Calendar calendar = Calendar.getInstance();//推荐使用
System.out.println(calendar);

/*
 *  getTime()
 *  该方法可以将当前Calendar表示的时间以Date形式返回
 */
Date date = calendar.getTime();
System.out.println(date);
long time = calendar.getTime().getTime();//获取时间毫秒数
System.out.println(time);

/*
* setTime(Date date)
* 该方法允许当前Calendar表示给定的Date所表示的时间
*/
calendar.setTime(new Date());
System.out.println(calendar);
```



**Calendar 的set用来设置Calendar中时间分量的值，get用来获取这些**值

```java
Calendar calendar = Calendar.getInstance();
//设置年
calendar.set(Calendar.YEAR, 2008);
//设置月
calendar.set(Calendar.MONTH, 7);
//设置日
calendar.set(Calendar.DAY_OF_MONTH, 8);
//设置时分秒此处略去
//calendar.set(2008, 7, 8, 20, 8, 8);//一次性设置的语句
System.out.println(calendar);
String time = new SimpleDateFormat("yyy-MM-dd HH:mm:ss E").format(calendar.getTime());
System.out.println(time);
```



**add(int filed,int value)操作时间**

```java
 //获取当前的Calendar
Calendar calendar = Calendar.getInstance();
Date date = calendar.getTime();
System.out.println(date);
//五天后是哪一天
calendar.add(Calendar.DAY_OF_YEAR, 5);
Date date1 = calendar.getTime();
System.out.println(date1);
//五天前是哪一天
calendar.add(Calendar.DAY_OF_YEAR, -5);
Date date2 = calendar.getTime();
System.out.println(date2);

```



**关于Calendar类中需要注意的：** 
月是从0开始的，即0表示一月，1表示二月……

HOUR_OF_DAY 24小时制

HOUR 12小时制

DAY_OF_YEAR 相对于年的日 即一年的第几天

DAY_OF_MONTH 相对于月的日 即几号

DAY_OF_WEEK 相对于周的日 即周几(周日为第一天，即1表示周日，0表示周六，7也可以表示周六)

DATE == DAY_OF_MONTH



### 1.3 springboot 返回restful



```java

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

	@GetMapping
	public Map<String,Object> sayHello(){
		Map<String,Object> map = new HashMap<>();
		map.put("code",1);
		map.put("msg","success");

		List<TvSeriesDto> list = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(2006,Calendar.OCTOBER,1,0,0,0);
		list.add(new TvSeriesDto(1,"大明王朝1566",c.getTime()));
		map.put("data",list);
        
		return  map;
	}
}

public class TvSeriesDto {
	private int id;
	private String name;
	private Date originReleaseDate;
    // 省略构造方法及set，get
}

//返回JSON为：
{
    msg: "success",
    code: 1,
    data: [
     {
        id: 1,
        name: "大明王朝1566",
        originReleaseDate: "2006-10-01"
      }
    ]
}
```



### 1.4 IDEA配置springboot热更新

- pom添加依赖：

```xml
<!--热部署-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```

-  “File” -> “Settings” -> “Build,Execution,Deplyment” -> “Compiler”，选中打勾 “Build project automatically” 
- 组合键：“Shift+Ctrl+Alt+/” ，选择 “Registry” ，选中打勾 “compiler.automake.allow.when.app.running” 



### 1.5 springboot 默认日志工具commons-logging

```java
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;

public class CLASS
{
    private Log log = LogFactory.getLog(CLASS.class);
    ...
    ;
    // 输出日志
    log.fatal(Object message);
    log.fatal(Object message, Throwable t);
    log.error(Object message);
    log.error(Object message, Throwable t);
    log.warn(Object message);
    log.warn(Object message, Throwable t);
    log.info(Object message);
    log.info(Object message, Throwable t);
    log.debug(Object message);
    log.debug(Object message, Throwable t);
    log.trace(Object message);
    log.trace(Object message, Throwable t);
}

```

配置：

```properties
logging.file='demo1.log'
logging.level.root="INFO"
logging.level.java="com.itshizhan"
```



使用及输出：

```java
@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

	private  Log log = LogFactory.getLog(TvSeriesDto.class);
    
	@GetMapping
	public Map<String,Object> sayHello(){

		log.info("sayHello() 方法调用了");

		Map<String,Object> map = new HashMap<>();
		map.put("code",1);
		map.put("msg","success");

		List<TvSeriesDto> list = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(2006,Calendar.OCTOBER,1,0,0,0);
		list.add(new TvSeriesDto(1,"大明王朝1566",c.getTime()));
		list.add(new TvSeriesDto(2,"康熙大帝",c.getTime()));

		map.put("data",list);

		return  map;
	}
}

// 访问：http://localhost:9001/tvseries 
// 输出：2018-09-10 23:32:22.374  ---com.itshizhan.TvSeriesDto   sayHello() 方法调用了
```









