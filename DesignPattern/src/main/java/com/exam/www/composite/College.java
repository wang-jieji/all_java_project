package com.exam.www.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 学院
 * @Author WJJ
 * @Date 2021/8/11 23:03
 **/
public class College extends OrganzationComponent{
    List<OrganzationComponent> organzationComponentList = new ArrayList<OrganzationComponent>();

    public College(String name, String des) {
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


    @Override
    public void print() {
        System.out.println("-----------------"+getName()+"---------------------");
        for(OrganzationComponent organzationComponent: organzationComponentList) {
            organzationComponent.print();
        }
    }
}
