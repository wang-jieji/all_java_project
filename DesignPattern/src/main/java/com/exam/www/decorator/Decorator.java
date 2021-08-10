package com.exam.www.decorator;

/**
 * @Description 装饰者
 * @Author WJJ
 * @Date 2021/8/10 19:05
 **/
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        // getPrice 自己价格
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        // drink.getDes() 输出被装饰者的信息
        return super.des + " " + super.getPrice() + " && " + drink.getDes() + " " + drink.getPrice();
    }
}
