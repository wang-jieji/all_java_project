package com.exam.www.composite;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/11 23:06
 **/
public class Client {
    public static void main(String[] args) {
        // 创建大学
        OrganzationComponent university = new University("清华大学", "中国顶级大学");

        // 创建学院
        OrganzationComponent computerCollege = new College("计算机学院", "新时代热门学院");
        OrganzationComponent infoEngineerCollege = new College("信息工程学院", "21世纪必不可少的学院");

        // 创建系
        computerCollege.add(new Department("软件工程","软件工程不错"));
        computerCollege.add(new Department("网络工程","网络工程不错"));
        computerCollege.add(new Department("计算机科学与技术","计算机与技术是老牌的专业"));

        infoEngineerCollege.add(new Department("通信工程","通信工程不好学"));
        infoEngineerCollege.add(new Department("信息工程","信息工程很好学"));

        // 将学院加入到大学
        university.add(computerCollege);
        university.add(infoEngineerCollege);

        // 显示大学所有信息
        university.print();

        // 只显示某个学院的信息
        //infoEngineerCollege.print();


    }
}
