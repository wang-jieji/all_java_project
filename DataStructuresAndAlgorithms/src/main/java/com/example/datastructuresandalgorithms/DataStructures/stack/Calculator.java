package com.example.datastructuresandalgorithms.DataStructures.stack;

import java.util.Stack;

/**
 * @Description 3、栈 实现 综合计算器
 * @Author WJJ
 * @Date 8/7/2022 下午10:12
 **/
public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-15+1-5+3-4";
        ArrayStack2 numStack = new ArrayStack2(20);
        ArrayStack2 operatorStack = new ArrayStack2(20);
        // 创建一个所以，遍历表达式
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        String keynum = "";
        int res = 0;
        int index = 0;
        while (true) {
            char curChar = expression.substring(index, index + 1).charAt(0);
            // 判断当前字符 curValue 是否是运算符
            if (operatorStack.isOperator(curChar)) {
                // 判断栈是否为空，为空直接入栈
                if (!operatorStack.isEmpty()) {
                    // 比较当前操作符与栈顶操作符的优先级
                    // 如果当前操作符优先级小与或等于栈顶操作符，就需要数栈中pop出两个数，在符栈中pop出一个运算符，进行计算
                    // 将计算结果入数栈，当前符号进符栈
                    if (operatorStack.priority(curChar) <= operatorStack.priority(operatorStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        res = operatorStack.cal(num1, num2, operator);
                        numStack.push(res);
                    }

                }
                operatorStack.push(curChar);

            } else {

                keynum += curChar;

                // 如果是最后一位，直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keynum));
                } else {
                    // 判断当前符号的下一位数是否是运算符，如果不是，index遍历到下一位，拼接字符
                    char nextChar = expression.substring(index + 1, index + 2).charAt(0);
                    // 当前符号的下一位数是运算符，直接入栈
                    if (operatorStack.isOperator(nextChar)) {
                        numStack.push(Integer.parseInt(keynum));
                        // 拼接字符穿置空
                        keynum = "";
                    }

                }

            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        System.out.printf("===============");
        // 遍历数栈和符号栈中，将结果放入数栈
        while (true) {
            if (operatorStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
            res = operatorStack.cal(num1, num2, operator);
            numStack.push(res);
        }

        // 将最后的结果输出
        res = numStack.pop();
        System.out.printf("表达式 %s=%d", expression, res);

    }

}

class ArrayStack2 {
    public int[] stack; // 栈的大小
    public int maxSize; // 数组，数组模拟栈，数据就存放在该数组里
    public int top = -1; // top 表示栈顶，初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * @Author WJJ
     * @Description 判断栈是否栈满
     **/
    public boolean isfull() {
        return top == maxSize - 1;
    }

    /**
     * @Author WJJ
     * @Description 判断栈是否栈满
     **/
    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * @Author WJJ
     * @Description 添加元素 入栈
     **/
    public void push(int value) {
        if (isfull()) {
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
        if (isEmpty()) {

            throw new RuntimeException("栈空~~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * @Author WJJ
     * @Description 遍历栈 从栈顶开始
     **/
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空~~");
        }
        //需要从栈顶显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n", i, stack[i]);
        }
    }

    /**
     * @Author WJJ
     * @Description 查看栈顶的元素。不出栈
     **/
    public int peek() {
        return stack[top];
    }

    /**
     * @Author WJJ
     * @Description 判断是否是一个运算符
     **/
    public boolean isOperator(char value) {
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    /**
     * @Author WJJ
     * @Description 返回运算符的优先级 优先级由程序员来确定
     **/
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * @Author WJJ
     * @Description 计算方法
     **/
    public int cal(int num1, int num2, int operator) {
        // 存放计算结果
        int res = 0;
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;

        }
        return res;
    }


}

