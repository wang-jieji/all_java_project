package com.exam.www.decorator;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/10 19:18
 **/
public class Soy extends Decorator{
    public Soy(Drink drink) {
        super(drink);
        setDes(" 豆浆 ");
        // 当前巧克力的价格
        setPrice(1.5f);
    }
}
