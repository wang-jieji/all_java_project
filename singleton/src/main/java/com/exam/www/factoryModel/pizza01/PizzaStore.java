package com.exam.www.factoryModel.pizza01;

import com.exam.www.factoryModel.simpleFactoryModel02.SimpleFactory;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 16:56
 **/
public class PizzaStore {
    public static void main(String[] args) {
        //new OrderPizza();

        new com.exam.www.factoryModel.simpleFactoryModel02.OrderPizza(new SimpleFactory());
    }
}
