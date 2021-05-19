package com.example.proxy.factory;


import com.example.proxy.impl.MyInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    /**
     * @Author WJJ
     * @Description //TODO
     * @Date 22:00 2021/4/12
     * @Param bj:被代理类的对象
     * @return
     */
    public static Object getProxyFactory(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }

}
