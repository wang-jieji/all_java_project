package com.exam.www.adpter.objectAdpter;

/**
 * @Description 适配器 与类适配器不同，不继承Voltage22v，而是组合Voltage22v。组合代替继承
 * @Author WJJ
 * @Date 2021/8/9 20:14
 **/
public class VoltageAdpater implements IVoltage5V {
    private Voltage220V voltage220V ;

    public VoltageAdpater(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }

    @Override
    public int outPut5V() {
        System.out.println("转换220v电压为5v");
        int orig = voltage220V.outPut220V();
        int tar = orig / 44 ;
        return tar;
    }
}
