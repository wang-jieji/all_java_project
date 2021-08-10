package com.exam.www.factoryModel.abstractSimpleFactory;

import com.exam.www.factoryModel.entity.Pizza;

/**
 * @Description 抽象工厂模式
 * @Author WJJ
 * @Date 2021/8/5 22:49
 **/
public interface AbstractFactory {
    public Pizza createPizaa(String orderType);
}
