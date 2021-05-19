package org.exam.www.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 可重入锁（也叫做递归锁）
 *
 * 指的是同一线程外层函数获取锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 *
 *   case one synchronized就是一个典型的可重入锁
 * t1	 invoke sendSMS()               t1线程在外层方法获取锁的时候
 * t1	 #######invoke sendEmail()      t1在进入内层方法会自动获取锁
 *
 *
 *   case two ReentrantLock也是一个典型的可重入锁
 * 
 * @Author WJJ
 * @Date 2021/4/17 0:59
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();


        try { TimeUnit.SECONDS.sleep(1); }catch (Exception e){ e.printStackTrace();}

        System.out.println("\n\n\n");

        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");

        t3.start();
        t4.start();

    }
}

class Phone implements Runnable{

    public synchronized void sendSMS() throws Exception{
        System.out.println( Thread.currentThread().getName()+"\t invoke sendSMS()");
        // 线程可以进入任何一个它已经拥有的锁所同步着的代码块
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception{
        System.out.println( Thread.currentThread().getName()+"\t #######invoke sendEmail()");
    }

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        try {
            // 线程可以进入任何一个它已经拥有的锁所同步着的代码块
            System.out.println( Thread.currentThread().getName()+"\t invoke get()");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println( Thread.currentThread().getName()+"\t #####invoke set()");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
