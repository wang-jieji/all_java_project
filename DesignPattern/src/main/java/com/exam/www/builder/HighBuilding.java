package com.exam.www.builder;



/**
 * @Description 高楼
 * @Author WJJ
 * @Date 2021/8/8 21:18
 **/
public class HighBuilding extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基100米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙10米");

    }

    @Override
    public void buildRoofed() {
        System.out.println("高楼屋顶");
    }
}
