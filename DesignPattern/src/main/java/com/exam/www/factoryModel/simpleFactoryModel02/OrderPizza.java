package com.exam.www.factoryModel.simpleFactoryModel02;


import com.exam.www.factoryModel.entity.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/4 18:42
 **/
public class OrderPizza {

    private SimpleFactory simpleFactory;

    public OrderPizza(SimpleFactory simpleFactory){
        do {
            String orderType = getType();
            Pizza pizza = SimpleFactory.createPizza(orderType);
            if(pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("披萨订购失败");
                break;
            }
        }while (true);
    }


    public static String getType(){
        String type = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入你想要的披萨类型:");
        try {
            type =  bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return type;
    }
}
