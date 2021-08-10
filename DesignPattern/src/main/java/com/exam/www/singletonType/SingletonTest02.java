package com.exam.www.singletonType;

/**
 * @Description 设计模式 单例模式 饿汉式(静态代码块)
 * @Author WJJ
 * @Date 2021/8/4 17:17
 **/
public class SingletonTest02 {

    private SingletonTest02(){

    }

    static {
        instance = new SingletonTest02();
    }

    private final static SingletonTest02 instance;

    public static SingletonTest02 getInstance(){
        return instance;
    }

}
