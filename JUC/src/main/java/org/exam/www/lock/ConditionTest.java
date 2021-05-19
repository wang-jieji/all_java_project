package org.exam.www.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 11:24
 **/

class ShareResource{
    // 标志位  1:A  2:B  3:C
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition conditionA  = lock.newCondition();
    private Condition conditionB  = lock.newCondition();
    private Condition conditionC  = lock.newCondition();

    public void print5(){

        lock.lock();
        try {
            //不等于一，表示不是A线程干活，那么A就等待，释放锁，让其他线程干活
            while (number != 1) {
                conditionA.await();
            }

            // 干活
            for (int i = 0 ; i < 5 ; i++){
                System.out.println( Thread.currentThread().getName()+" : A");
            }

            // 判断
            number = 2 ;
            // 通知B打印
            conditionB.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){

        lock.lock();
        try {
            while (number != 2) {
                conditionB.await();
            }

            // 干活
            for (int i = 0 ; i < 10 ; i++){
                System.out.println( Thread.currentThread().getName()+" : B");
            }

            number = 3 ;
            // 通知C打印
            conditionC.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){

        lock.lock();
        try {
            while (number != 3) {
               conditionC.await();
            }

            // 干活
            for (int i = 0 ; i < 15 ; i++){
                System.out.println( Thread.currentThread().getName()+" : C");
            }

            number = 1 ;
            // 通知A打印
            conditionA.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}

/**
 * @Author
 * @Description 题目：多线程之间按照顺序调用，实现A->B->C
 *                    三个线程启动，要求如下
 *                    AA打印5次，BB打印10此，CC打印15次
 *                    接着
 *                    AA打印5次，BB打印10此，CC打印15次
 *                    ......来10轮
 * @Date
 */
public class ConditionTest {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print5();
            }
        },"线程A").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print10();
            }
        },"线程B").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print15();
            }
        },"线程C").start();
    }


}
