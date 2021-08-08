package com.exam.www.factoryModel.pizza01;

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

    public OrderPizza(){
        Pizza pizza = null;
        String orderType ;

        do{
            orderType = getType();
            if("greek".equals(orderType)) {
                pizza = new GreekPizza();
                pizza.setName("希腊披萨");
            } else if("cheess".equals(orderType)) {
                pizza = new CheessPizza();
                pizza.setName("奶酪披萨");
            }else if("china".equals(orderType)) {
                pizza = new ChinaPizza();
                pizza.setName("中国披萨");
            }else {
                break;
            }

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

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
