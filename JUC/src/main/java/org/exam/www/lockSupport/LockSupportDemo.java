package org.exam.www.lockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/19 22:12
 **/
public class LockSupportDemo {
    public static void main(String[] args) {



      Thread th1 =  new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t 被唤醒");
        }, "AA");
      th1.start();

        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(3); }catch (Exception e){ e.printStackTrace();}
            System.out.println( Thread.currentThread().getName()+"\t 唤醒 "+th1.getName());
            LockSupport.unpark(th1);
        },"BB").start();
    }
}
