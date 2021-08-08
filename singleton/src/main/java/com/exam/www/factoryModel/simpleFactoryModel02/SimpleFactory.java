package com.exam.www.factoryModel.simpleFactoryModel02;

import com.exam.www.factoryModel.entity.Pizza;
import com.exam.www.factoryModel.pizza01.CheessPizza;
import com.exam.www.factoryModel.pizza01.ChinaPizza;
import com.exam.www.factoryModel.pizza01.GreekPizza;

/**
 * @Description 简单工厂模式
 * @Author WJJ
 * @Date 2021/8/5 17:01
 **/
public class SimpleFactory {

    public static Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("greek".equals(orderType)) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if("cheess".equals(orderType)) {
            pizza = new CheessPizza();
            pizza.setName("奶酪披萨");
        }else if("china".equals(orderType)) {
            pizza = new ChinaPizza();
            pizza.setName("中国披萨");
        }
        return pizza;
    }

}
