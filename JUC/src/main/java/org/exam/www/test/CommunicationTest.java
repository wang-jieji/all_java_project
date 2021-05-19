package org.exam.www.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 线程通信的例子：使用两个线程打印 1-100 。线程1，线程2 交替打印
 * @Author WJJ
 * @Date 2021/4/13 2:48
 **/
public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number).start();
        new Thread(number).start();

    }

}

class Number implements Runnable{

    private int number = 1;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            synchronized (this){

                // 唤醒处于阻塞状态的线程
                notify();
                if(number <= 100) {
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    //使得调用如下wait方法的线程进入阻塞状态，会释放锁
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }

        }
    }
}
