package com.example.datastructuresandalgorithms.DataStructures.linkedlist;

import java.util.Arrays;

/**
 * @Description 双向链表 无头
 * @Author WJJ
 * @Date 3/7/2022 下午9:50
 **/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "公孙胜", "入云龙");
        Node node5 = new Node(5, "关 胜", "大刀");

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);
        linkedList.delete(node5);

        linkedList.list(linkedList.getNode());

    }

}

class DoubleLinkedList{
    // 第一个节点
    private Node node;

    public Node getNode() {
        return node;
    }

    /**
     * @Author WJJ
     * @Description 尾插法
     **/
    public void add(Node newNode){
        // 将新节点的数据赋值给第一个节点
        if (node == null) {
            node = new Node(newNode);
            return;
        }
        Node tempNode = node;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
        }
        // 已经到链表最后
        tempNode.next = newNode;
        tempNode.next.pre = tempNode;
    }

    /**
     * @Author WJJ
     * @Description 头插法
     **/
    public void addHead(Node newNode) {
        // 如果链表为空，将新节点的数据赋值给第一个节点
        if (node == null) {
            node = new Node(newNode);
            return;
        }
        node.pre = newNode;
        node.pre.next = node;
        // 将新节点引用为第一个节点
        node = newNode;
    }

    /**
     * @Author WJJ
     * @Description 根据编号删除某个节点
     **/
    public void delete(Node deleteNode) {
        if(node == null) {
            return;
        }
        boolean flag = false;
        Node cur = node;
        while (true) {
            if(cur == null) {
                break;
            }
            if(cur.no == deleteNode.no) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        // 当前遍历到的节点就是目标节点
        if(flag) {
            // 如果删除的时第一个节点，将指针后移
            if(cur.pre == null) {
                cur = cur.next;
                node = cur;
            }else {
                cur.pre.next = cur.next;
            }
            if(cur.next != null) {
                cur.next.pre = cur.pre;
            }
        }
        if(!flag) {
            System.out.println("该节点在链表中不存在");
        }


    }




    public void list(Node firstNode) {
        //判断当前链表是否为空

        if (firstNode == null) {
            System.out.println("链表为空~~");
            return;
        }
        while (firstNode != null) {
            System.out.println(firstNode);
            // 将指针指向后一位节点
            firstNode = firstNode.next;
        }
    }


}


class Node {
    int no;
    String name;
    String nickName;
    Node next;
    Node pre;

    public Node(int no, String name, String niceName) {
        this.no = no;
        this.name = name;
        this.nickName = niceName;
    }

    public Node(Node node) {
        this.no = node.no;
        this.name = node.name;
        this.nickName = node.nickName;
    }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}