package org.exam.www.lock.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/14 0:14
 **/
public class ThreadPoolCustomizeDemo {

    public static void main(String[] args) {
        /*
        * corePoolSize 线程池中的常驻核心线程数。
        * maximumPoolSize 线程池中能够容纳同时执行的最大线程数 // 最大线程数等于CPU核数+1
        * keepAliveTime 多余的空闲线程的存活时间当前池中线程数量超过corePoolSize时， 当空闲时间达到keepAliveTime时，多余线程会被销毁直到只剩下corePoolSize个线程为止
        * unit keepAliveTime的单位
        * workQueue 任务队列，被提交但尚未被执行的任务
        * threadFactory 表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认即可
        * */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors() + 1,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 16; i++) {
                threadPool.execute(()->{
                    System.out.println( Thread.currentThread().getName()+"\t办理业务");
                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //
            threadPool.shutdown();
        }
    }
}
