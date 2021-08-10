package com.exam.www.singletonType;

/**
 * @Description 设计模式 单例模式 懒汉式(线程不安全)
 * @Author WJJ
 * @Date 2021/8/4 17:17
 **/
public class SingletonTest03 {

    private SingletonTest03(){

    }

    private static SingletonTest03 instance;

    public static SingletonTest03 getInstance(){
        if(instance == null) {
            return instance = new SingletonTest03();
        }
        return instance;
    }

}
