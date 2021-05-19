package org.exam.www.lock.countDown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 15:46
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("******集齐7颗龙珠，出来吧，神龙");
        });
        for (int i = 1; i <= 7 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println( Thread.currentThread().getName()+"\t收集到第: "+tempInt+"颗龙珠");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
    }
}
