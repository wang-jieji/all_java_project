package com.exam.www.factoryModel.simpleFactoryMethodModel03;

import com.exam.www.factoryModel.entity.Pizza;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 18:17
 **/
public class LDCheessPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦芝士披萨");
        System.out.println("伦敦芝士披萨，准备材料中");
    }
}
