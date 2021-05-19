package org.exam.www.lock.ArrayList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 12:07
 **/
public class NotSafeDemo {

    public static void main(String[] args) {

        Map<String,String> map = new ConcurrentHashMap<>();

        for(int i = 1 ; i <= 30 ; i++) {
            new Thread(() -> {
                map.put( Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }
}
