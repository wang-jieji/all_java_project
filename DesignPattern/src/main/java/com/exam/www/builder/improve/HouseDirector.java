package com.exam.www.builder.improve;

/**
 * @Description 指挥者 指定制作流程
 * @Author WJJ
 * @Date 2021/8/8 21:20
 **/
public class HouseDirector {
   HouseBulider houseBulider = null ;

    public HouseDirector(HouseBulider houseBulider) {
        this.houseBulider = houseBulider;
    }

    public void setHouseBulider(HouseBulider houseBulider) {
        this.houseBulider = houseBulider;
    }

    public House constructHouse(){
        houseBulider.buildBasic();
        houseBulider.buildWalls();
        houseBulider.buildRoofed();
        return houseBulider.buildHouse();
    }
}
