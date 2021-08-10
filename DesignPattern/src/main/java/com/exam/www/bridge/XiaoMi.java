package com.exam.www.bridge;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 21:52
 **/
public class XiaoMi implements Brand{

    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }
}
