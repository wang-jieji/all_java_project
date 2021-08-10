package com.exam.www.decorator;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/10 19:00
 **/
public class Coffee extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
