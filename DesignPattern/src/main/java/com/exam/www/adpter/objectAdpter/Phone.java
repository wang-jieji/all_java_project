package com.exam.www.adpter.objectAdpter;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/9 20:16
 **/
public class Phone {

    //充电
    public void charging(IVoltage5V voltage5V){
        if(voltage5V.outPut5V() == 5 ){
            System.out.println("电压为5v，可以正常充电");
        } else {
            System.out.println("电压不正常，请勿冲电");
        }
    }
}
