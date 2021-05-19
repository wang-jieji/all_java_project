package org.exam.www.stream;

import java.util.function.Function;

/**
 * @Description Function<T,R>函数式接口  输入一个 T 类型的参数，返回一个 R 类型的参数
 * @Author
 * @Date
 **/
public class FunctionInterDemo {
    public static void main(String[] args) {
        // 普通
        Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        System.out.println(function.apply("abc"));

        //第二种 Landa表达式
        Function<String,Integer> function1 = (s) -> {return s.length();};
        System.out.println(function1.apply("abc"));
    }
}
