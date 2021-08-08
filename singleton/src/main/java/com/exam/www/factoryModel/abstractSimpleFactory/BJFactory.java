package com.exam.www.factoryModel.abstractSimpleFactory;

import com.exam.www.factoryModel.entity.Pizza;
import com.exam.www.factoryModel.simpleFactoryMethodModel03.BJCheessPizza;
import com.exam.www.factoryModel.simpleFactoryMethodModel03.BJPepperPizza;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 22:50
 **/
public class BJFactory implements AbstractFactory{
    @Override
    public Pizza createPizaa(String orderType) {
        System.out.println("抽象工厂模式");
        Pizza pizza = null;
        if("cheess".equals(orderType)) {
            pizza = new BJCheessPizza();
        } else if("pepper".equals(orderType)){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
