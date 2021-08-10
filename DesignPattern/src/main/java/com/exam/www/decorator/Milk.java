package com.exam.www.decorator;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/10 19:18
 **/
public class Milk extends Decorator{
    public Milk(Drink drink) {
        super(drink);
        setDes(" 牛奶 ");
        // 当前巧克力的价格
        setPrice(2.0f);
    }
}
