package org.exam.www.stream;

import org.exam.www.bean.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 题目：请按照给出的数据，找出同时满足以下条件的用户，也即以下条件全部满足
 *              偶数ID 且 年龄大于24 且 用户名转为大写 且 用户名字母倒排序
 *              只输出一个用户名
 * @Author
 * @Date
 **/
public class StreamDemo {
    public static void main(String[] args) {

        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 32);
        User u3 = new User(13, "c", 25);
        User u4 = new User(14, "d", 5);
        User u5 = new User(160, "e", 28);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        // 对集合过滤 filter(Predicate<? super T> predicate)  predicate参数是断定型接口: 输入一个 T 类型的参数 ，永远只返回Boolean类型的数据
        // 对集合遍历 forEach(Consumer<? super T> action) 消费型接口：输入一个 T 类型参数 ，没有返回值
        // 处理集合里的元素 map(Function<? super T,? extends R> mapper)  Function<T, R> 函数型接口:输入一个 T 类型的参数，返回一个 R 类型的参数
        // 排序 sorted(Comparator<? super T> comparator)
        list.stream().filter(u -> {return u.getId() % 2 == 0 ;}) //过滤id不是偶数的
                     .filter(t -> {return t.getAge() > 24;})     //过滤年龄小于24的
                     .map(m -> {return m.getName().toUpperCase();}) //用户名转为大写
                     .sorted((o1,o2) -> {return o2.compareTo(o1);}) // 字母倒序
                     .limit(1)                                      // 只获取一条数据
                     .forEach(System.out::println);

        // map方法举例 把集合里的元素都乘2
        List<Integer> asList = Arrays.asList(1, 2, 3);
        asList  = asList
                .stream()   // 将 List类型转为stream 类型
                .map(x -> {return x * 2;})
                .collect(Collectors.toList());  // 将stream类型转为List类型

    }
}
