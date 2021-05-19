package org.exam.www.stream;

import java.util.function.Predicate;

/**
 * @Description Predicate<T>函数式接口 输入一个 T 类型的参数 ，永远只返回Boolean类型的数据
 * @Author WJJ
 * @Date 2021/4/15 0:21
 **/
public class PredicateInterDemo {
    public static void main(String[] args) {
        // 第一种
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate.test("123"));

        // 第二种
        Predicate<String> predicate1 = s -> {return s.isEmpty();};
        System.out.println(predicate1.test("123"));


    }
}
