package org.exam.www.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/16 18:37
 **/
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019)+" atomic value "+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+" atomic value "+atomicInteger.get());

        atomicInteger.getAndIncrement();
    }
}
