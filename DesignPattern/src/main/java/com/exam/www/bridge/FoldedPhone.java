package com.exam.www.bridge;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 21:57
 **/
public class FoldedPhone extends Phone{


    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open(){
        System.out.println("华为折叠手机");
        super.open();
    }

    @Override
    public void call(){
        System.out.println("华为折叠手机");
        super.call();
    }

    @Override
    public void close(){
        System.out.println("华为折叠手机");
        super.close();
    }

}
