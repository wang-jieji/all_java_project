package org.exam.www.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 手写自旋锁
 * @Author WJJ
 * @Date 2021/4/17 1:53
 **/
public class SpanLockDemo {

    /**
     * 原子类引用线程
     */
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void MyLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t come in O(∩_∩)O");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void UnMyLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println( Thread.currentThread().getName()+"\t go out o(╥﹏╥)o");
    }


    public static void main(String[] args) {
        SpanLockDemo spanLockDemo = new SpanLockDemo();
        new Thread(() -> {
            spanLockDemo.MyLock();
            try { TimeUnit.SECONDS.sleep(5); }catch (Exception e){ e.printStackTrace();}
            spanLockDemo.UnMyLock();
        },"A").start();

        try { TimeUnit.SECONDS.sleep(1); }catch (Exception e){ e.printStackTrace();}

        new Thread(() -> {
            spanLockDemo.MyLock();

            spanLockDemo.UnMyLock();
        },"B").start();

    }
}
