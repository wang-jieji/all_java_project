package com.example.proxy.impl;


import com.example.Interface.Human;

public class SuperMan implements Human {
    @Override
    public String getBelief() {
       return "I believe I can fly!";
    }

    @Override
    public void ear(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
