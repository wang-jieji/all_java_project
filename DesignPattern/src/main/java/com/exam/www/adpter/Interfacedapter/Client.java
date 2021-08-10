package com.exam.www.adpter.Interfacedapter;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 20:45
 **/
public class Client {
    public static void main(String[] args) {
        AbstractAdpter abstractAdpter = new AbstractAdpter(){
            // 只需要覆盖我们需要使用接口方法
            @Override
            public void m1(){
                System.out.println("使用了m1的方法");
            }
        };
        abstractAdpter.m1();
    }
}
