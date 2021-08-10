package com.exam.www.factoryModel.simpleFactoryMethodModel03;

import com.exam.www.factoryModel.entity.Pizza;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 19:14
 **/
public class LDOrderPizza extends OrderPizza {


    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheess".equals(orderType)) {
            pizza = new LDCheessPizza();
        }else if("pepper".equals(orderType)) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }


}
