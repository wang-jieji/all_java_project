package com.exam.www.builder.improve;

/**
 * @Description 抽象建造者
 * @Author WJJ
 * @Date 2021/8/8 21:09
 **/
public abstract class HouseBulider {
    public House house = new House();

    /**
     * 打地基
     */
    public abstract void buildBasic();
    /**
     * 建墙壁
     */
    public abstract void buildWalls();
    /**
     * 盖屋顶
     */
    public abstract void buildRoofed();

    /**
     * 建好房子，将产品（房子）返回
     */
    public House buildHouse(){
        return house;
    }
}
