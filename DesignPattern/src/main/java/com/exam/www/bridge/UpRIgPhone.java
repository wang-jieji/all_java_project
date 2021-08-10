package com.exam.www.bridge;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 22:09
 **/
public class UpRIgPhone extends Phone{
    public UpRIgPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open(){
        System.out.println("华为直立手机");
        super.open();
    }

    @Override
    public void call(){
        System.out.println("华为直立手机");
        super.call();
    }

    @Override
    public void close(){
        System.out.println("华为直立手机");
        super.close();
    }
}
