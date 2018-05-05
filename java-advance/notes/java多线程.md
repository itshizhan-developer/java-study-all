# java 多线程

java是多线程的编程语言。

java多线程的应用体现在哪里？

如何实现一个java的多线程主类？
- 继承一个Thread类；
- [推荐]实现Runnable、Callable接口；


## 1.继承Thread类实现多线程

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

> 结论：多线程的启动：start()方法，调用此方法会在底层调用run方法

## 2. Runnable实现多线程
由于Thread 单继承的局限。推荐使用Runnable接口

```java
@FunctionalInterface
public interface Runnable{
	public void run();
}
```

```java
class MyRunnable implements Runnable {
	private String title;

	public MyRunnable(String title) {
		this.title = title;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.title + ",x=" + i);
		}
	}
}


// 调用
public class Main {
 public static void main(String[] args) {	
   MyRunnable runnableA = new MyRunnable("线程A");
   MyRunnable runnableB = new MyRunnable("线程B");
   new Thread(runnableA).start();
   new Thread(runnableB).start();
		
 }
}

```
> 同样会交替执行。注意启动方法：`new Thread(Runnable target).start()`

## 使用匿名内部类
```java
public class Main {
  public static void main(String[] args) {
  new Thread(new Runnable() {
   @Override
   public void run() {
     System.out.println("匿名类别类实现线程:hello world");
   }
  }).start();

  new Thread(()-> System.out.println("匿名类别类Lambda表达式:hello world")).start();
  }
}
```

## Thread类与Runnable接口的区别和联系：
- 1. Thread 实现了 Runnable 接口, 同时覆写了run 方法
```java
// 源码
public class Thread implements Runnable {
  @Override
  public void run() {
    if (target != null) {
      target.run();
    }
  }
}
```
- 2. 都需要重写里面run()方法
- 3. 实现Runnable的类更具有健壮性，避免了单继承的局限 
- 4. Runnable**更容易实现资源共享**，能多个线程同时处理一个资源
例如：
```java
public class Main {

  public static void main(String[] args) {

    //测试Runnable
    MyThread1 t1 = new MyThread1();
    new Thread(t1).start();//同一个t1，如果在Thread中就不行，会报错
    new Thread(t1).start();
    new Thread(t1).start();

  }

}
class MyThread1 implements Runnable{
  private int ticket = 10;
  @Override
  //记得要资源公共，要在run方法之前加上synchronized关键字，要不然会出现抢资源的情况
  public synchronized  void  run() {
    for (int i = 0; i <10; i++) {
      if (this.ticket>0) {
        System.out.println("卖票：ticket"+this.ticket--);
      }
    }  
  }
}
// 输出结果：
卖票：ticket10
卖票：ticket8
卖票：ticket6
卖票：ticket5
卖票：ticket4
卖票：ticket9
卖票：ticket2
卖票：ticket3
卖票：ticket7
卖票：ticket1

```
- 5. Thread有start()方法，但是Runnable接口没有start()方法；Runnable 只有run 方法。

>提醒：Runnable只是更容易实现资源共享。Thread实际上也可以实现资源共享。


## 3.实现Callable接口实现多线程

```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```
- 关键点： 有返回值，并且可以抛出异常。
- Callable需要依赖FutureTask，用于接收运算结果。一个产生结果，一个拿到结果。FutureTask是Future接口的实现类，也可以用作闭锁。

例如：计算1加到10的结果

```java
public class Main {
  public static void main(String[] args) {

    MyCallableThread myCallableThread = new MyCallableThread();
    FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallableThread);

    new Thread(futureTask).start();
    try {
      Integer sum = futureTask.get();
      System.out.println("从1加到10 = "+sum);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }


  }
}


class MyCallableThread implements Callable<Integer>{

  @Override
  public Integer call() throws Exception {
    int sum = 0;
    for(int i=1;i<11;i++){
      System.out.println("i:"+i);
      sum+=i;
    }
    return sum;
  }
}
// 输出结果：
i:1
i:2
i:3
i:4
i:5
i:6
i:7
i:8
i:9
i:10
从1加到10 = 55

```

#### Callable关键点：

```java
//FutureTask源码
public class FutureTask<V> implements RunnableFuture<V> {

  // 实现了 Future 中的get方法，可以获取 返回值。
  public V get() throws InterruptedException, ExecutionException {
    int s = state;
    if (s <= COMPLETING)
        s = awaitDone(false, 0L);
    return report(s);
  }
}

//RunnableFuture源码
public interface RunnableFuture<V> extends Runnable, Future<V> {
  /**
    * Sets this Future to the result of its computation
    * unless it has been cancelled.
    */
  void run();
}

//Thread 构造函数
public Thread(Runnable target) {
    init(null, target, "Thread-" + nextThreadNum(), 0);
}
/******************
 Thread 可以接收 Runnable，而FutureTask 通过 RunnableFuture 继承自 Runnable，
因此 Thread 可以接收 FutureTask，即 上文中的：  new Thread(futureTask).start();
*/
```


# 线程的运行状态

thread 调用start 方法后，并不一定立即执行。而是进入就绪状态，等待进行调度后执行。

# 多线程常用API：主要集中在Thread类上

