package com.exam.www.singletonType;

/**
 * @Description 设计模式 单例模式 懒汉式(线程安全)推荐使用
 * @Author WJJ
 * @Date 2021/8/4 17:17
 **/
public class SingletonTest04 {

    private SingletonTest04(){

    }

    private static volatile SingletonTest04 instance = null;

    public static SingletonTest04 getInstance(){
        if(instance == null) {
            synchronized (SingletonTest04.class){
                if(instance == null) {
                    return instance = new SingletonTest04();
                }
            }
        }
        return instance;
    }

}
