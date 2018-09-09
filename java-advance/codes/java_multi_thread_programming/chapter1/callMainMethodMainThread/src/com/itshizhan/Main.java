package com.itshizhan;

public class Main {

    public static void main(String[] args) {
        new MyThread().start();
        System.out.println("Main.main:" + Thread.currentThread().getName());
        System.out.println("运行结束");

    }
}


class  MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread.run");
    }
}