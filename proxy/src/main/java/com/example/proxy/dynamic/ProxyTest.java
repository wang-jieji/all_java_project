package com.example.proxy.dynamic;

/*
 要实现动态代理，需要解决的问题？
 问题一：如何根据加载到内存中的被代理类，动态的创建一个 代理类 及其对象
 问题二：当通过代理类的对象调用方法时，如何 动态的 去调用 被代理类中的 同名方法
*/


import com.example.Interface.Human;
import com.example.proxy.factory.ProxyFactory;
import com.example.proxy.impl.SuperMan;

public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // proxyInstance：代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyFactory(superMan);
        // 当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        System.out.println(proxyInstance.getBelief());
        proxyInstance.ear("汉堡");

    }
}
