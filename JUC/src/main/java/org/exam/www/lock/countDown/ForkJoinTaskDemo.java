package org.exam.www.lock.countDown;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/14 0:59
 **/
public class ForkJoinTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0,100);
        ForkJoinPool threadPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = threadPool.submit(myTask);
        System.out.println(forkJoinTask.get());
        threadPool.shutdown();
    }
}


class MyTask extends RecursiveTask<Integer>{

    private static final Integer ADJUST_VALUE = 10;
    private static final Integer num = 1 ;

    private int begin;
    private int end;
    private int result;

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public MyTask(int begin,int end){
        this.begin = begin ;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end - begin) <= ADJUST_VALUE) {
            for (int i = begin; i <= end ; i++) {
                result = result + i;
            }
        }else {
            int middle = (end + begin) / 2;
            MyTask task01 = new MyTask(begin, middle);
            MyTask task02 = new MyTask(middle+1, end);
            task01.fork();
            task02.fork();
            result = task01.join() + task02.join();
        }
        return result;
    }
}