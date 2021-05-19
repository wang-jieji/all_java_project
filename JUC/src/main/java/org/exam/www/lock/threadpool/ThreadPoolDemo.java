package org.exam.www.lock.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 21:23
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //ExecutorService threadPool1 = Executors.newFixedThreadPool(3);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();/
        // 一池n个工作线程，类似一个银行有1个受理窗口
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println( Thread.currentThread().getName()+"\t办理业务");
                });
                try { TimeUnit.SECONDS.sleep(1); }catch (Exception e){ e.printStackTrace();}
            }
        }catch (Exception e){
           e.printStackTrace();
        }finally {
                //
                threadPool.shutdown();
        }
    }
}
