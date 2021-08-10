package com.exam.www.adpter.classAdpter;

/**
 * @Description 适配器
 * @Author WJJ
 * @Date 2021/8/9 20:14
 **/
public class VoltageAdpater extends Voltage220V implements IVoltage5V {
    @Override
    public int outPut5V() {
        System.out.println("转换220v电压为5v");
        int orig = outPut220V();
        int tar = orig / 44 ;
        return tar;
    }
}
