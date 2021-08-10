package com.exam.www.builder;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/8 21:35
 **/
public abstract class AbstractHouse {
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

    public void buildHouse(){
        buildBasic();
        buildWalls();
        buildRoofed();
    }
}
