package com.itshizhan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*不共享数据
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
        */

        /*

        MyThreadTwo myThreadTwo = new MyThreadTwo();

        Thread a = new Thread(myThreadTwo,"A");
        Thread b = new Thread(myThreadTwo,"B");
        Thread c = new Thread(myThreadTwo,"C");
        Thread d = new Thread(myThreadTwo,"D");
        Thread e = new Thread(myThreadTwo,"E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        */
        /*
        Alogin alogin = new Alogin();
        alogin.start();
        Blogin blogin = new Blogin();
        blogin.start();
        */
        MyThread myThread = new MyThread("A");
        System.out.println("isAlive:" + myThread.isAlive() );
        myThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("isAlive:" + myThread.isAlive() );
       // myThread.interrupt();

    }
}
