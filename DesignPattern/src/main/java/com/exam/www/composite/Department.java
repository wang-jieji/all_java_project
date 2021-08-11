package com.exam.www.composite;

/**
 * @Description  系(Leaf 叶子节点)
 * @Author WJJ
 * @Date 2021/8/11 23:04
 **/
public class Department extends OrganzationComponent{

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
