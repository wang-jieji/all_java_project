package org.exam.www.lock.blockingQueue;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/19 17:24
 **/
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue queue = new SynchronousQueue();
        new Thread(() -> {

            try {
                System.out.println( Thread.currentThread().getName()+"\t put A");
                queue.put("A");
                System.out.println( Thread.currentThread().getName()+"\t put B");
                queue.put("B");
                System.out.println( Thread.currentThread().getName()+"\t put C");
                queue.put("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(() -> {

            try {

                try { TimeUnit.SECONDS.sleep(5); }catch (Exception e){ e.printStackTrace();}
                System.out.println( Thread.currentThread().getName()+"\t 获取"+queue.take());

                try { TimeUnit.SECONDS.sleep(5); }catch (Exception e){ e.printStackTrace();}
                System.out.println( Thread.currentThread().getName()+"\t 获取"+queue.take());

                try { TimeUnit.SECONDS.sleep(5); }catch (Exception e){ e.printStackTrace();}
                System.out.println( Thread.currentThread().getName()+"\t 获取"+queue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}

class MyRejected implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

    }
}
