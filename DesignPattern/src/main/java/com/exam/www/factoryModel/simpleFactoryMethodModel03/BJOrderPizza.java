package com.exam.www.factoryModel.simpleFactoryMethodModel03;

import com.exam.www.factoryModel.entity.Pizza;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 19:14
 **/
public class BJOrderPizza extends OrderPizza {
    public BJOrderPizza() {
        super();
    }

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheess".equals(orderType)) {
            pizza = new BJCheessPizza();
        }else if("pepper".equals(orderType)) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
