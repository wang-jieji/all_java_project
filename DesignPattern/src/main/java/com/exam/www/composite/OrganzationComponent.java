package com.exam.www.composite;

/**
 * @Description component
 * @Author WJJ
 * @Date 2021/8/11 22:50
 **/

public abstract class OrganzationComponent {

    public String name;
    public String des;

    public OrganzationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void add(OrganzationComponent organzationComponent){
        // 默认实现方法
        new UnsupportedOperationException();
    }

    public void remove(OrganzationComponent organzationComponent){
        // 默认实现方法
        new UnsupportedOperationException();
    }

    // 由子类去实现
    public abstract void print();
}
