package com.exam.www.adpter.classAdpter;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 20:20
 **/
public class Client {
    public static void main(String[] args) {
        System.out.println("类适配器模式");
        new Phone().charging(new VoltageAdpater());
    }
}
