package com.exam.www.factoryModel.pizza01;

import com.exam.www.factoryModel.entity.Pizza;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/4 18:36
 **/
public class CheessPizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("给制作奶酪披萨 准备原材料~~");
    }
}
