package com.exam.www.factoryModel.entity;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/5 21:52
 **/
public class Pizza {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void prepare(){
        System.out.println(name + "~正在准备中~~");
    }

    public void bake(){
        System.out.println(name + "~正在拷贝中~~");
    }
    public void cut(){
        System.out.println(name + "~正在切块中~~");
    }
    public void box(){
        System.out.println(name + "~正在打包派送中~~");
    }

}
