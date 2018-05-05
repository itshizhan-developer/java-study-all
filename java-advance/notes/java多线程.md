# java 多线程

java是多线程的编程语言。

java多线程的应用体现在哪里？

如何实现一个java的多线程主类？
- 继承一个Thread类；
- [推荐]实现Runnable、Callable接口；


## 继承Thread类实现多线程

继承类java.lang.Thread类，覆写run 方法
```java
// 一个线程的主体类
// 一个线程的主体类
class MyThread extends Thread {
  private String title;

  public MyThread(String title) {
    this.title = title;
  }

  @Override
  public void run() {
    //所有线程从此处开始执行
    //super.run();
    for (int i = 0; i < 10; i++) {
      System.out.println(this.title + ",x=" + i);
    }
	
  }
}


public class Main {
  public static void main(String[] args) {

    MyThread threadA = new MyThread("线程A");
    threadA.run();
    MyThread threadB = new MyThread("线程B");
    threadB.run();

  }
}


```

```sh
// 输出结果：各个线程对象依次执行
线程A,x=0
线程A,x=1
线程A,x=2
线程A,x=3
线程A,x=4
线程A,x=5
线程A,x=6
线程A,x=7
线程A,x=8
线程A,x=9
线程B,x=0
线程B,x=1
线程B,x=2
线程B,x=3
线程B,x=4
线程B,x=5
线程B,x=6
线程B,x=7
线程B,x=8
线程B,x=9
```

如果将main方法改为如下：
```java
MyThread threadA = new MyThread("线程A");
threadA.start();
MyThread threadB = new MyThread("线程B");
threadB.start();
```
则输出如下：
```sh
线程A,x=0
线程B,x=0
线程A,x=1
线程A,x=2
线程A,x=3
线程A,x=4
线程A,x=5
线程A,x=6
线程B,x=1
线程B,x=2
线程B,x=3
线程A,x=7
线程B,x=4
线程B,x=5
线程A,x=8
线程A,x=9
线程B,x=6
线程B,x=7
线程B,x=8
线程B,x=9
```

> 结论：多线程的启动：start()方法，调用此方法会调用run方法

