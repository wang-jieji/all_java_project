package com.exam.www.factoryModel.abstractSimpleFactory;

import com.exam.www.factoryModel.entity.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 22:53
 **/
public class OrderFactory {

    public OrderFactory(AbstractFactory abstractFactory) {
        Pizza pizza = null;
        String type = "";
        do {
            type = getType();
            pizza = abstractFactory.createPizaa(type);
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("没有这种类型的披萨");
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
