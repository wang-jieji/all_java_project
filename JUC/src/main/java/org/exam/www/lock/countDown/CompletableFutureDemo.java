package org.exam.www.lock.countDown;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/14 1:28
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t没有返回，update mysql ok");
        });
        completableFuture.get();

        CompletableFuture<Integer> integercompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t有返回，update mysql ok");
            //int age = 10/0 ;
            return 1024;
        });

        System.out.println(integercompletableFuture.whenComplete((t, u) -> {
            System.out.println("****t " + t);
            System.out.println("****u " + u);
        }).exceptionally(f -> {
            System.out.println("****excption: " + f.getMessage());
            return 44444;
        }).get());

    }
}
