package org.exam.www.stream;

import java.util.function.Supplier;

/**
 * @Description Supplier<T>函数式接口  没有输入参数 返回一个 T类型的参数
 * @Author WJJ
 * @Date 2021/4/15 0:35
 **/
public class SupplierInterDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "123456";
            }
        };
        System.out.println(supplier.get());

        Supplier<String> supplier1 = () -> {return "123456";};
        System.out.println(supplier1.get());
    }
}
