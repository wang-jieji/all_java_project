package com.exam.www.builder.improve;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/8 21:28
 **/
public class Clien {
    public static void main(String[] args) {
        // 不同房子
        CommomHouser commomHouser = new CommomHouser();
        HighBuilding highBuilding = new HighBuilding();
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(highBuilding);
        // 完成盖房子，返回产品
        House house = houseDirector.constructHouse();
    }
}
