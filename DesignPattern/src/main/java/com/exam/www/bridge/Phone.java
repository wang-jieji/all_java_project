package com.exam.www.bridge;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 21:54
 **/
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand){
        this.brand = brand;
    }

    public void open(){
        brand.open();
    }

    public void call(){
        brand.call();
    }

    public void close(){
        brand.close();
    }

}
