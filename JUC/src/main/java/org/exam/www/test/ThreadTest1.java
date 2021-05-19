package org.exam.www.test;

/**
 * @Description TODO
 * @Author 使用同步方法解决实现Runnable接口的线程安全问题
 * @Date 2021/4/13 1:51
 **/
class Window2 implements Runnable {

    private static int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {
            if(ticket > 0) {
                System.out.println(Thread.currentThread().getName()+":卖票，票号为"+ticket);
                ticket--;
            }
        }
    }


public class ThreadTest1 {

    public static void main(String[] args) {
        Window2 w = new Window2();
        Thread thread1 = new Thread(w);
        Thread thread2 = new Thread(w);
        Thread thread3 = new Thread(w);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
