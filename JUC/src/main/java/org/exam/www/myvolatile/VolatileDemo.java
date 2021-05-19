package org.exam.www.myvolatile;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description volatile可见性
 * @Author WJJ
 * @Date 2021/4/16 15:50
 **/
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        CountDownLatch downLatch = new CountDownLatch(20);

        for(int i = 0 ; i < 20 ; i++ ){
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
                downLatch.countDown();
            },String.valueOf(i)).start();

        }

        try {
            downLatch.await();
            System.out.println( Thread.currentThread().getName()+"\t int type, final number value "+myData.number);
            System.out.println( Thread.currentThread().getName()+"\t atomicInteger type, final number value "+myData.atomicInteger);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     *  volatile的可见性测试  变量number没加volatile和加了volatile之后的不同
    */
    private static void seeOkVolatile() {
        MyData myData = new MyData();

        new Thread(()-> {
            System.out.println( Thread.currentThread().getName()+"\t 进入");
            try { TimeUnit.SECONDS.sleep(3); }catch (Exception e){ e.printStackTrace();}
            myData.addTo60();
            System.out.println( Thread.currentThread().getName()+"\t 出来");
        },"AA").start();

        while (myData.number == 0) {

        }

        System.out.println( Thread.currentThread().getName()+"\t 得到通知 number="+myData.number);
    }
}


class MyData{

    /**
    * 加volatile
    */
   volatile int number = 0 ;

    /**
     * 不加volatile
     */
    //int number = 0 ;

    public void addTo60(){
        this.number = 60 ;
    }

    /**
     * number已经加了volatile
     */
    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}