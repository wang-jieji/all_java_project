package com.exam.www.bridge;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 21:53
 **/
public class HuaWei implements Brand{
    @Override
    public void open() {
        System.out.println("华为手机开机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void close() {
        System.out.println("华为手机关机");
    }
}
