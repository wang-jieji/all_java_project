package com.exam.www.singletonType;

/**
 * @Description 设计模式 单例模式 静态内部类(推荐使用)
 * @Author WJJ
 * @Date 2021/8/4 17:17
 **/
public class SingletonTest05 {

    private SingletonTest05(){

    }

    /**
    *
     */
    private static class SingletonInstance{
        private static SingletonTest05 instance = new SingletonTest05();
    }



    public static SingletonTest05 getInstance(){
       return SingletonInstance.instance;
    }

}
