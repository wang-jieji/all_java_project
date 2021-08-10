package com.exam.www.factoryModel.simpleFactoryMethodModel03;

import com.exam.www.factoryModel.entity.Pizza;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 18:14
 **/
public class BJCheessPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京芝士披萨");
        System.out.println("北京芝士披萨，准备材料中");
    }
}
