package org.exam.www.lock.countDown;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 16:24
 **/

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void put(String key, String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println( Thread.currentThread().getName()+"\t写入数据"+key);
            // 暂停一下
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);
            System.out.println( Thread.currentThread().getName()+"\t写入完成");
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println( Thread.currentThread().getName()+"\t读取数据"+key);
            // 暂停一下
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            Object result = map.get(key);
            System.out.println( Thread.currentThread().getName()+"\t读取完成");
        }catch (Exception e){
           e.printStackTrace();
        }finally {
           readWriteLock.readLock().unlock();
        }

    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <= 5 ; i++) {
            final int tempInt = i ;
            new Thread(() -> {
                myCache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5 ; i++) {
            final int tempInt = i ;
            new Thread(() -> {
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
