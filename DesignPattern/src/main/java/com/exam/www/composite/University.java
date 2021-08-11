package com.exam.www.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description University 就是 Composite,可以管理College
 * @Author WJJ
 * @Date 2021/8/11 22:54
 **/
public class University extends OrganzationComponent{

    List<OrganzationComponent> organzationComponentList = new ArrayList<OrganzationComponent>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrganzationComponent organzationComponent) {
        organzationComponentList.add(organzationComponent);
    }

    @Override
    public void remove(OrganzationComponent organzationComponent) {
        organzationComponentList.remove(organzationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    // print方法，就是输出University 包含的学院
    @Override
    public void print() {
        System.out.println("-----------------"+getName()+"---------------------");
        for(OrganzationComponent organzationComponent: organzationComponentList) {
            organzationComponent.print();
        }
    }
}
