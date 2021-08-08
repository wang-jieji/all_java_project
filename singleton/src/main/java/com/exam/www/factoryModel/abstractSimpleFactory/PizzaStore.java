package com.exam.www.factoryModel.abstractSimpleFactory;

import com.exam.www.factoryModel.simpleFactoryModel02.SimpleFactory;

import java.util.Calendar;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 16:56
 **/
public class PizzaStore {
    public static void main(String[] args) {
        //new OrderPizza();

        //new OrderFactory(new BJFactory());
        new OrderFactory(new LDFactory());
        final Calendar instance = Calendar.getInstance();
    }
}
