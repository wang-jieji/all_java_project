package org.exam.www.test;

/**
 * @Description 使用同步方法解决实现RThread类的线程安全问题
 * @Author
 * @Date 2021/4/13 1:51
 **/
class Window3 extends Thread {

    private static int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show() {
        if(ticket > 0) {
            System.out.println(Thread.currentThread().getName()+":卖票，票号为"+ticket);

            ticket--;
        }
    }
}


public class ThreadTest2 {

    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();

        w1.start();
        w2.start();
        w3.start();
    }
}
