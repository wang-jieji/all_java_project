package com.example.proxy.factory;


import com.example.proxy.impl.MyInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 调用此方法，返回一个代理类的对象。
    public static Object getProxyFactory(Object obj){  // obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }

}
