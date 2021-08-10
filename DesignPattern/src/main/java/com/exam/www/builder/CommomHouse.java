package com.exam.www.builder;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/8 21:37
 **/
public class CommomHouse extends AbstractHouse{
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙10cm");
    }

    @Override
    public void buildRoofed() {
        System.out.println("普通房子屋顶");
    }
}
