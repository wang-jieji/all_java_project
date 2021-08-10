package com.exam.www.decorator;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/10 19:18
 **/
public class Chocolate extends Decorator{
    public Chocolate(Drink drink) {
        super(drink);
        setDes(" 巧克力");
        // 当前巧克力的价格
        setPrice(3.0f);
    }
}
