/**
 * Created by leeson8888 on 2018/5/5.
 */

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
