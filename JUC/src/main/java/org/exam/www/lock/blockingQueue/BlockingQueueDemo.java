package org.exam.www.lock.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 16:46
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //当定义队列大小为3时，如果再插入队列，会抛出 IllegalStateException 异常
        //System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // 检查队列
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        //当队列为空时，再删除队列，会抛出 NoSuchElementException 异常
        //System.out.println(blockingQueue.remove());


        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 当定义队列大小为3时，如果再插入队列，会返回false,和add不一样，不会抛出 IllegalStateException 异常
        //1、System.out.println(blockingQueue.offer("d"));
        // 要解决队列阻塞问题，可以设置超时时间
        System.out.println(blockingQueue.offer("d", 3L, TimeUnit.SECONDS));


        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //当队列为空时，再删除队列，会返回null 不会和remove一样抛出 NoSuchElementException 异常
        //System.out.println(blockingQueue.poll());

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 当队列满时，再插入队列，将会一直阻塞，直到队列腾出位置为止
        //blockingQueue.put("d");



        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 当队列空时，take会一直阻塞队列，直到队列中有新元素能获取
        //System.out.println(blockingQueue.take());


    }
}
