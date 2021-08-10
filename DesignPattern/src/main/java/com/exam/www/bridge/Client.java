package com.exam.www.bridge;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 22:07
 **/
public class Client {
    public static void main(String[] args) {
        Phone foldedPhone =  new FoldedPhone(new HuaWei());
        foldedPhone.open();
        foldedPhone.call();
        foldedPhone.close();

        System.out.println("\n");

        Phone upRIgPhone =  new UpRIgPhone(new HuaWei());
        upRIgPhone.open();
        upRIgPhone.call();
        upRIgPhone.close();
    }
}
