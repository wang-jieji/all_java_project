package com.example.datastructuresandalgorithms.DataStructures.queue;

import java.util.Scanner;

/**
 * @Description 循环队列
 * @Author WJJ
 * @Date 2022/6/20 0:07
 **/
public class CircleArrayQueueDemo {
    private int[] queue; //定义一个数组
    private static int maxSize; // 队列最大值
    private int rear; // 指向队列的尾部
    private int front; // 指向队列的头部

    public static void main(String[] args) {
        //测试
        // 创建一个队列
        CircleArrayQueueDemo arrayQueueDemo = new CircleArrayQueueDemo(4);
        // 获取用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取出一个数");
            System.out.println("p(peek): 查看队列的头部数据");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueueDemo.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个整数: ");
                    int value = scanner.nextInt();
                    arrayQueueDemo.addQueue(value);
                    break;
                case 'g':
                    try {
                        int queue = arrayQueueDemo.getQueue();
                        System.out.printf("取出的数据是%d\n", queue);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        arrayQueueDemo.peekQueue();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }

    /**
     * 定义一个队列的构造器
     */
    private CircleArrayQueueDemo(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        queue = new int[maxSize];
        rear = 0;
        front = 0;
    }

    /**
     * 判断队列是否为空
     */
    private boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判断队列是否满
     */
    private boolean isFull() {
        return (rear + 1 ) % maxSize == front ;
    }

    /**
     * 添加数据队列
     */
    private void addQueue(int value) {
        if (isFull()) {
            System.out.println("队列满了，不能加入数据~~~");
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % maxSize ;
    }

    /**
     * 从队列中取出数据,出队列
     */
    private int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据取出~~~");
        }
        int num = queue[front];
        queue[front] = 0 ;
        front = (front + 1) % maxSize ;
        return num;
    }

    /**
     * 显示队列
     */
    private void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~~");
        }
        for (int i = front; i < front + queueSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, queue[i % maxSize]);
        }
    }

    /**
     * 输出队列头部数据，显示
     */
    private void peekQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~~");
        }

        int frontValue = queue[front];
        System.out.printf("头部数据为：%d\n", frontValue);
    }

    /**
     * 获取队列中 有效数据 的个数
     */
    private int queueSize() {
        return (rear+ maxSize-front ) % maxSize;
    }

}
