package com.exam.www.decorator;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/10 19:21
 **/
public class CoffeeBar {
    public static void main(String[] args) {
        //1. 点一份 LongBlack
        Drink order = new LongBlack();

        //2. order 加一份牛奶
        order = new Milk(order);

        //3. order 加两块巧克力
        order = new Chocolate(order);

        System.out.println("order 加入一份牛奶 加入一份巧克力 费用 ="+order.cost());
        System.out.println("order 加入一份牛奶 加入一份巧克力 描述 ="+order.getDes());


    }
}
