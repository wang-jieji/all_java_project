package org.exam.www.myvolatile;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/16 18:04
 **/
public class SingletonDemo {

    private static volatile   SingletonDemo instance = null ;

    private SingletonDemo(){
        System.out.println( Thread.currentThread().getName()+"\t 我是构造方法SingletonDemo()");
    }

    // DEL (Double Check Lock) 双端检索机制
    public static SingletonDemo getInstance(){
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance ;
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 20 ; i++ ){
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
