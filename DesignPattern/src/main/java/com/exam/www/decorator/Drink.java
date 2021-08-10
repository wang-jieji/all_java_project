package com.exam.www.decorator;

/**
 * @Description 装饰者模式
 * @Author WJJ
 * @Date 2021/8/10 18:58
 **/
public abstract class Drink {
    public String des; // 描述
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
