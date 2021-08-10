package com.exam.www.singletonType;

/**
 * @Description 设计模式 单例模式 饿汉式(静态常量)
 * @Author WJJ
 * @Date 2021/8/4 17:17
 **/
public class SingletonTest01 {

    private SingletonTest01(){

    }

    private final static SingletonTest01 instance = new SingletonTest01();

    public static SingletonTest01 getInstance(){
        return instance;
    }

}
