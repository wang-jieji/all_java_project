package org.exam.www.lock.countDown;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 16:00
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println( Thread.currentThread().getName()+"\t抢占到车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    }catch (Exception e){
                       e.printStackTrace();
                    }
                    System.out.println( Thread.currentThread().getName()+"\t离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }

    }
}
