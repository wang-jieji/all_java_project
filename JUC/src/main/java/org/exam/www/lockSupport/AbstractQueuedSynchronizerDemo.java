package org.exam.www.lockSupport;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 通过ReentrantLock研究AQS机制
 * @Author WJJ
 * @Date 2021/4/19 23:46
 **/
public class AbstractQueuedSynchronizerDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        lock.unlock();


    }
}
