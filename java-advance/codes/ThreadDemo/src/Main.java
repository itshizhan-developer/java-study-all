import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

	public static void main(String[] args) {

		/*
		new Thread(new Runnable() {
			@Override
			public void run() {
					System.out.println("匿名类别类实现线程:hello world");
			}
		}).start();

		new Thread(()-> System.out.println("匿名类别类Lambda表达式:hello world")).start();
		*/

		//测试Runnable
		/*
		MyThread1 t1 = new MyThread1();
		new Thread(t1).start();//同一个t1，如果在Thread中就不行，会报错
		new Thread(t1).start();
		new Thread(t1).start();
		*/

		MyCallableThread myCallableThread = new MyCallableThread();

		FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallableThread);

		new Thread(futureTask).start();


		try {
			Integer sum = futureTask.get();
			System.out.println("从1加到100 = "+sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}


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