package com.example.datastructuresandalgorithms.DataStructures.stack;


import java.util.Scanner;

/**
 * @Description 2、用单向链表模拟栈
 * @Author WJJ
 * @Date 8/7/2022 上午12:50
 **/
public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
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
                        stack.list(stack.getHead());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pu":
                    System.out.println("请输入一个整数: ");
                    int value = scanner.nextInt();
                    Node node = new Node(value);
                    stack.push(node);
                    break;
                case "po":
                    try {
                        stack.pop(stack.getHead());
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

class LinkedListStack{
    // 定义一个头节点
    // 将头节点作为栈底
    private Node head = new Node(0);

    public Node getHead() {
        return head;
    }

    /**
     * @Author WJJ
     * @Description 入栈 尾插法 将新节点都插在总端节点的后面
     **/
    public void push(Node node) {
        // 应为head节点是不能改变的，所以用一个临时节点存放head指针
        Node temp = head;
        // 从头开始遍历所有节点，直到找到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果不是最后一个节点，将temp指针后移
            temp = temp.next;
        }
        //退出循环后，temp就指向了链表的最后一个节点
        // 将最后一个节点的next 指向 新的节点
        temp.next = node;
    }

    /**
     * @Author WJJ
     * @Description 将栈顶的数据返回 出栈
     **/
    public void pop(Node head){
        if(head.next == null) {
            throw new RuntimeException("栈空~~");
        }
        // 遍历链表到最后一位
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            // 这是链表的最后,说明链表中只有一个节点
            if(temp.next == null) {
                flag = true;
                break;
            }
            // 这是链表的倒数第二个节点
            if(temp.next.next ==null) {
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            System.out.println("链表中取出的数据是："+temp);
            head.next = null;
        }else {
            System.out.println("链表中取出的数据是："+temp.next);
        }
        temp.next = null;
        //退出循环后，temp就指向了链表的倒数第二个节点

    }

    /**
     * @Author WJJ
     * @Description 遍历栈 从栈顶开始（将链表反向输出打印）
     * 思路 ： 1 先定义一个节点 resverseHead = new Node()
     *        2 将要反向输出的链表遍历，将遍历出来的节点 按照 头插法 插入 resverseHead节点 。最后输出新链表
     **/
    public void list(Node head) {
        if(head.next == null) {
            throw new RuntimeException("栈空~~");
        }
        Node resverseHead = new Node(0);
        Node curNode = head.next;
        // 创建临时节点存放当前节点 [curNode] 指向的下一节点的指针
        Node nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;

            // 重新创建一个变量存放当前节点，因为原节点不能改变
            Node tempNode = new Node(curNode);

            // 将头节点 的 next 赋值给 当前节点。这样新节点插入时，next 就能指向上一个插入的节点
            tempNode.next = resverseHead.next;
            // 将 头节点的 next 指向 当前节点
            resverseHead.next = tempNode;
            curNode = nextNode;
        }
        linkedlist(resverseHead);
    }

    /**
     * @Author WJJ
     * @Description 遍历链表
     **/
    public void linkedlist(Node head) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }

        Node tempNode = head.next;
        while (true) {
            // 判断当前节点是否为空
            if (tempNode == null) {
                break;
            }
            System.out.println(tempNode);
            // 将指针指向后一位节点
            tempNode = tempNode.next;
        }
    }




}

/**
 * @Description 创建一个节点类
 **/
class Node {
    int no;
    Node next;



    public Node(int no) {
        this.no = no;
    }

    public Node(Node node) {
        this.no = node.no;
        this.next = node.next;

    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}


