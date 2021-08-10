package com.exam.www.adpter.objectAdpter;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 20:20
 **/
public class Client {
    public static void main(String[] args) {
        System.out.println("对象适配器模式");
        new Phone().charging(new VoltageAdpater(new Voltage220V()));
    }
}
