package com.example.datastructuresandalgorithms.DataStructures.stack;

import java.util.Scanner;

/**
 * @Description 1、栈 用数组模拟栈
 * @Author WJJ
 * @Date 7/7/2022 下午11:40
 **/
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        // 获取用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示栈");
            System.out.println("e(exit): 退出程序");
            System.out.println("pu(push): 添加数据到栈(入栈)");
            System.out.println("po(pop): 从栈中取出数据(出栈)");
            String key = scanner.next();
            switch (key) {
                case "s":
                    try {
                        arrayStack.list();

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pu":
                    System.out.println("请输入一个整数: ");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "po":
                    try {
                        int num = arrayStack.pop();
                        System.out.printf("栈中取出的数据是%d\n", num);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayStack {
    public int[] stack; // 栈的大小
    public int maxSize; // 数组，数组模拟栈，数据就存放在该数组里
    public int top = -1; // top 表示栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * @Author WJJ
     * @Description 判断栈是否栈满
     **/
    public boolean isfull(){
        return top == maxSize -1 ;
    }

    /**
     * @Author WJJ
     * @Description 判断栈是否栈满
     **/
    public boolean isEmpty(){
        return top == -1 ;
    }



    /**
     * @Author WJJ
     * @Description 添加元素 入栈
     **/
    public void push(int value) {
        if(isfull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    /**
     * @Author WJJ
     * @Description 将栈顶的数据返回 出栈
     **/
    public int pop() {
        if(isEmpty()) {

           throw new RuntimeException("栈空~~");
        }
        int value = stack[top] ;
        top--;
        return value;
    }

    /**
     * @Author WJJ
     * @Description 遍历栈 从栈顶开始
     **/
    public void list(){
        if(isEmpty()) {
            throw new RuntimeException("栈空~~");
        }
        //需要从栈顶显示数据
        for(int i = top ; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d \n",i,stack[i]);
        }
    }


}
