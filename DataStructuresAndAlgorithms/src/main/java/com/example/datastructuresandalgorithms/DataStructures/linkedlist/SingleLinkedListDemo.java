package com.example.datastructuresandalgorithms.DataStructures.linkedlist;

import java.util.Stack;

/**
 * @Description 单向链表的创建
 * @Author WJJ
 * @Date 2/7/2022 上午12:34
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5, "关 胜", "大刀");
        HeroNode newNode = new HeroNode(1, "宋江小人", "烂人");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addOrder(node1);
        singleLinkedList.addOrder(node2);
        singleLinkedList.addOrder(node3);
        singleLinkedList.addOrder(node5);
        singleLinkedList.addOrder(node4);
        //singleLinkedList.addhead(singleLinkedList.getHead(),node1);
        singleLinkedList.update(newNode);

        // 删除编号为1的节点
        //singleLinkedList.delete(node1);

       // singleLinkedList.delete(node1);
        singleLinkedList.list(singleLinkedList.getHead());
       int length = singleLinkedList.length(singleLinkedList.getHead());
        System.out.printf("当前链表的有效节点的个数为：%d\n",length);

        // 找到链表中的倒数第K个元素
        System.out.println("========查找链表中第k个元素===============");
        HeroNode nodeByLastIndex = singleLinkedList.findNodeByLastIndex(singleLinkedList.getHead(), 5);
        System.out.println(nodeByLastIndex);

        // 将链表反转并输出
        System.out.println("========链表反转===============");
       singleLinkedList.reverseHead(singleLinkedList.getHead());

       // 链表逆向输出并且破坏链表结构 用stack栈
        System.out.println("========链表逆向输出===============");
        singleLinkedList.reversePrint(singleLinkedList.getHead());

    }
}

/**
 * @Author WJJ
 * @Description 创建一个单链表类
 **/
class SingleLinkedList {
    // 创建一个头节点
    HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * @Author WJJ
     * @Description 添加方法 尾插法 将新节点都插在总端节点的后面
     **/
    public void add(HeroNode node) {
        // 应为head节点是不能改变的，所以用一个临时节点存放head指针
        HeroNode temp = head;
        // 从头开始遍历所有节点，直到找到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果不是最后一个节点，将指针后移
            temp = temp.next;
        }
        //退出循环后，指针就指向了链表的最后一个节点
        // 将最后一个节点的next 指向 新的节点
        temp.next = node;
    }

    /**
     * @Author WJJ
     * @Description 添加方法 头插法 将新节点都插在总端节点的后面
     **/
    public void addhead(HeroNode head,HeroNode node) {
        HeroNode temp = head;
        // 将头节点的next存放在临时变量中
        HeroNode tempNode = temp.next;
        // 将新节点插入到头节点之后
        temp.next = node;
        // 将之前头节点指向的指针插入到新节点后
        node.next = tempNode;

    }

    /**
     * @Author WJJ
     * @Description 添加方法 根据排名将节点插入指定位置
     **/
    public void addOrder(HeroNode node) {
        HeroNode tempNode = head;
        // 标志位，判断要插入的节点是否已经存在
        boolean flag = false;
        while (true) {
            if(tempNode.next == null) {
                // 该节点已经是链表最后一个节点
                break;
            }
            // 如果temp指针指向的下一个节点的排名比新节点大，说明新节点应该插入到temp节点后面
            if (tempNode.next.no > node.no ) {
                break;
            }
            // 新节点在链表中已存在
            if (tempNode.next.no == node.no) {
                flag = true;
            }
            tempNode = tempNode.next;
        }
        if(flag) {
            System.out.printf("编号 %d 在链表中已经存在\n",node.no);
        }
        // 将 tempNode 节点指向后一位节点的指针赋值给新节点
        node.next = tempNode.next;
        // 将tempNode 节点指向后一位节点的指针指向新节点
        tempNode.next = node;
    }

    /**
     * @Author WJJ
     * @Description 更新节点数据
     **/
    public void update(HeroNode newNode) {
        HeroNode temp = head ;
        // 标志位，判断该节点是否存在
        boolean flag = false;
        // 注意 tempNode已经是 头节点指向的节点
        HeroNode tempNode = temp.next;
        while (true) {
            // 已经到链表的最后节点
            if(tempNode == null) {
                break;
            }
            if(tempNode.no == newNode.no) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if(flag) {
            tempNode.name = newNode.name;
            tempNode.nickName = newNode.nickName;
        }
        if(!flag) {
            System.out.printf("编号 %d 在链表中不存在",newNode);
        }
    }

    /**
     * @Author WJJ
     * @Description 删除节点
     **/
    public void delete(HeroNode node) {
        HeroNode temp = head ;
        // 标志位，判断该节点是否存在
        boolean flag = false;

        while (true) {
            // 已经到链表的最后节点
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
           temp.next = temp.next.next;
        }
        if(!flag) {
            System.out.printf("编号 %d 在链表中不存在",node.no);
        }
    }


    /**
     * @Author WJJ
     * @Description 查找单链表中的倒数第k个节点 length -index
     **/
    public HeroNode findNodeByLastIndex(HeroNode head , int index){
        // 判断为空 ，返回null
        if(head.next == null) {
           return null;
        }
        // 获取链表的长度
        int length = length(head);

        // index校验
        if(index <= 0 || index > length){
            return null;
        }
        // for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < length - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    /**
     * @Author WJJ
     * @Description 将链表反向输出打印
     * 思路 ： 1 先定义一个节点 resverseHead = new HeroNode()
     *        2 将要反向输出的链表遍历，将遍历出来的节点 按照 头插法 插入 resverseHead节点 。最后输出新链表
     **/
    public void reverseHead(HeroNode head) {
        if(head.next == null) {
            return;
        }
        HeroNode resverseHead = new HeroNode(0,"","");
        HeroNode curNode = head.next;
        // 创建临时节点存放当前节点 [curNode] 指向的下一节点的指针
        HeroNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            // 将头节点 的 next 赋值给 当前节点。这样新节点插入时，next 就能指向上一个插入的节点
            curNode.next = resverseHead.next;
            // 将 头节点的 next 指向 当前节点
            resverseHead.next = curNode;
            curNode = nextNode;
        }
        // 将 原链表的 next 指向 resverseHead的next ，这样 原链表head 就实现了反转
        head.next = resverseHead.next;
        list(resverseHead);
    }

    /**
     * @Author WJJ
     * @Description 逆序输出链表 用栈 不会改变链表的结构
     **/
    public void reversePrint(HeroNode head){
        if(head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode node = head.next;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

    /**
     * @Author WJJ
     * @Description 计算链表的有效节点的个数
     **/
    public int length(HeroNode head){
        int length = 0 ;
        if(head.next == null) {
            return  0;
        }
        HeroNode cur = head.next ;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * @Author WJJ
     * @Description 遍历链表
     **/
    public void list(HeroNode head) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }

        HeroNode tempNode = head.next;
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
class HeroNode {
    int no;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int no, String name, String niceName) {
        this.no = no;
        this.name = name;
        this.nickName = niceName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}