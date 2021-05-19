package org.exam.www.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/15 0:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(int id , String name ,int age) {
        this.id = id ;
        this.name = name;
        this.age = age;
    }

    private int id;
    private int age;
    private String name;

}
