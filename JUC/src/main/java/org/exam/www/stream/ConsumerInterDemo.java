package org.exam.www.stream;

import java.util.function.Consumer;

/**
 * @Description Consumer<T>函数式接口  输入一个 T 参数 ，没有返回值
 * @Author WJJ
 * @Date 2021/4/15 0:28
 **/
public class ConsumerInterDemo {
    public static void main(String[] args) {
        // 普通的匿名内部类写法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        //Lambda表达式写法
        Consumer<String> consumer1 = s -> { System.out.println(s); };
    }
}
