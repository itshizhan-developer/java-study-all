# java集合相关知识笔记

概念：存放数据的一个容器

与数组的比较：

- 数组的长度固定，不能添加元素
- 数组能存基本数据类型和引用数据类型

- 集合的长度可以改变，长度随着元素的增加而增加
- 能存储任意的对象，只能存储引用数据类型。对于基本类型，会自动进行装箱。


# 1. 集合分类
```
<img src="https://github.com/itshizhan/java_study_notes/blob/master/java-basic/notes/images/collections-icon1.png?raw=true"/>
```

实例：

```java
  // 面向接口编写，运行时，表现来的是子类的特征（多态）
  Collection c = new ArrayList();
  boolean b1 = c.add("abc");
  boolean b2 = c.add(10);
  boolean b3 = c.add(true);

  Student s = new Student();
  s.setName("Lesson");
  s.setAge("17");
  boolean b4 = c.add(s);
  boolean b5 = c.add("abc");

  System.out.println(b1);
  System.out.println(b2);
  System.out.println(b3);
  System.out.println(b4);
  System.out.println(b5);
  // 以上全部返还 true
 
  System.out.println(c);
  // [abc, 10, true, Student@2503dbd3, abc]
```
> List 可以添加重复元素； 可以自动装箱； 覆盖了toString方法




# 2.collection常用方法

- `remove() `: 删除集合中指定的元素
- `clear()` : 清空集合中所有的元素
- `size()`: 获取集合的长度

实例：
```java
  Collection c = new ArrayList();
  c.add("a");
  c.add("b");
  c.add("c");

  System.out.println(c);

  c.remove("a");
  System.out.println(c);
  System.out.println(c.size());

  c.clear();
  System.out.println(c.size());

  //依次输出：
  [a, b, c]
  [b, c]
  2
  0
```

### 集合的遍历

1. 转为数组进行遍历：

```java
  Collection c = new ArrayList();
  c.add("a");
  c.add("b");
  c.add("c");

  System.out.println(c);

  // 注意Object类型
  Object[] arr = c.toArray();
  for(int i=0;i<arr.length;i++){
    System.out.println("集合遍历，下标"+i+"："+arr[i]);
  }
  // 输出结果为：
  [a, b, c]
  集合遍历，下标0：a
  集合遍历，下标1：b
  集合遍历，下标2：c
```

注意：如何集合中存放对象，需要进行类型转换。

```java
// 省略main 方法：  CollectionsFour()

public  static void  CollectionsFour(){
  Collection c = new ArrayList();
  c.add(new Dog("dog1"));
  c.add(new Dog("dog2"));
  

  Object[] arr = c.toArray();
  for(int i=0;i<arr.length;i++){
    System.out.println("集合数据："+arr[i]);
    Dog dog = (Dog)arr[i];
    System.out.println("集合数据："+dog.getName());
  }

}


class Dog{
  private  String name;

  public Dog(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

// 输出结果
集合数据：Dog@2503dbd3
集合数据：dog1
集合数据：Dog@4b67cf4d
集合数据：dog2
```

2. 迭代器进行遍历

```java
  Collection c = new ArrayList();
  c.add("a");
  c.add("b");
  c.add("c");

  // Iterator 中的内容自动提升为Object类型
  // 如果是对象，获取值时需要 强制转换 
  Iterator it = c.iterator();
  while(it.hasNext()){
    System.out.println(it.next());
  }

```



### 集合其他方法：

- addAll(c): 集合合并
- removeAll(c): 删除两个集合的交集
- containsAll(c): 判断集合是否包含传入集合
- retainAll(c): 取交集，并赋值给调用者



# 4. List集合

# 5. ArrayList集合

# 6. LinkedList 集合

# 7. Vector

# 8. 集中中使用泛型


# 9.  Set集合

# 10. HashCode

# 11. HashSet

# 12. TreeSet

# 13. Map集合

# 14. LinkedHashMap

# 15. HashMap

# 16. HashTable





