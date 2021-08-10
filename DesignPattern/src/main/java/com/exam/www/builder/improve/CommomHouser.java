package com.exam.www.builder.improve;

/**
 * @Description 普通房子
 * @Author WJJ
 * @Date 2021/8/8 21:15
 **/
public class CommomHouser extends HouseBulider {
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
