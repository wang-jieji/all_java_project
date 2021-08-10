package com.exam.www.factoryModel.simpleFactoryMethodModel03;

import com.exam.www.factoryModel.entity.Pizza;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 18:16
 **/
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒披萨");
        System.out.println("北京胡椒披萨，准备材料中");
    }
}
