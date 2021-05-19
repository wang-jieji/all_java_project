package org.exam.www.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 3:18
 **/
public class ThreadTest4 {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);

        new Thread(futureTask).start();
        try {
            // get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0 ;
        Lock lock = new ReentrantLock();
        for (int i = 1 ; i <= 100 ;i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
