package org.exam.www.lock.countDown;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 要子线程都执行完成主线程才能结束
 * @Author
 * @Date
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) {
        // 参数为6是应为for循环创建了6个线程
        CountDownLatch downLatch = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
                new Thread(() -> {
                    System.out.println( Thread.currentThread().getName()+"\t离开教室");
                    // 计数器减1
                    downLatch.countDown();
                },String.valueOf(i)).start();
        }
        try {
            // CountDownLatch的计数器值没有变为0之前，调用await的线程都会阻塞。这里是main线程阻塞
            downLatch.await();
            System.out.println( Thread.currentThread().getName()+"\t主线程离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
