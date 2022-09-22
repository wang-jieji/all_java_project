package com.example.datastructuresandalgorithms.DataStructures.hashTable;
import java.util.Scanner;

/**
 * @Description 哈希表
 * @Author WJJ
 * @Date 22/9/2022 15:38
 **/
public class HashTableDemo {

    public static void main(String[] args) {
        HashTabel hashTabel = new HashTabel(7);
        String key = "";
        // 获取用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("a(add): 添加雇员");
            System.out.println("l(list): 显示雇员");
            System.out.println("f(find): 查找雇员");
            System.out.println("e(exit): 退出程序");
            key = scanner.next();
            switch (key) {
                case "a":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTabel.add(emp);
                    break;
                case "l":
                    hashTabel.list();
                    break;
                case "f":
                    System.out.println("输入id");
                    int empIdd = scanner.nextInt();
                    hashTabel.findEmpById(empIdd);
                    break;
                case "e":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

}

class HashTabel{
    public int size;

    public EmpLinkedList[] empLinkedListArray;

    public HashTabel(int size) {
        this.size = size;
        // 初始化empLinkedListArray,并将数组中的每一个链表初始化
        empLinkedListArray = new EmpLinkedList[size];
        for(int i = 0 ; i< size ; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp) {
        // 根据员工id,判断该员工应当添加到哪条链表当中
        int empLinkedListNo = hashFun(emp.id);
        // 将emp添加到对应的两表当中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    // 遍历所有链表
    public void list() {
        for(int i = 0 ; i< size ; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    // 根据输入的id查找雇员
    public void findEmpById(int id){
        //使用散列函数确定查找哪个链表
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(emp != null) {
            System.out.printf("在第 %d 条链表中找到雇员 id=%d\n",(empLinkedListNo+1),id);
        }else {
            System.out.println("在哈希表中，没有找到该雇员 ");
        }
    }


    // 编写散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }

}


class EmpLinkedList {

    // 定义指针，代表第一个员工节点，默认null
    private Emp head;

    // 在链表中添加一个新节点
    public void add(Emp emp) {
        // 如果为空则添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            // 表明到链表的最后一个节点
            if(curEmp.next == null) {
                break;
            }
            // 指针后移
            curEmp = curEmp.next;
        }
        // 将数据加入到链表中
        curEmp.next = emp;
    }

    // 在链表中删除雇员节点信息
    public void del(Emp emp) {
        if (head == null) {
            System.out.println("链表为空，无数据");
            return;
        }
        // 标志位
        boolean flag = false;
        Emp curEmp = head;

        // 如果删除的是第一个节点
        if(curEmp.id == emp.id) {
            // 如果第一个节点后面还有节点，将指针指向后一个节点
            if(curEmp.next != null ) {
                head = curEmp.next;
            } else {
                // 否则第一个节点置空
                head = null;
            }
            System.out.printf("成功删除id=%d的员工信息",emp.id);
            return;
        }

        while (true) {
            if(curEmp.next == null) {
                break;
            }
            // 要把当前节点的下一个节点与要删除的节点做对比
            if(curEmp.next.id == emp.id) {
                flag = true;
                break;
            }
            // 将指针指向下一个节点
            curEmp = curEmp.next;
        }

        if(flag) {
            // 说明要删除的节点是最后一个节点,则将指向下一个置为空
            if(curEmp.next.next == null) {
                curEmp.next = null;
            }else {
                curEmp.next = curEmp.next.next;
            }

        }
        if(!flag) {
            System.out.println("没有找到需要删除的数据");
        }
        return;
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空，无数据");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if(curEmp.id == id) {
                break;
            }
            // 说明链表在最后一个节点
            if(curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第"+(no+1)+"链表为空");
            return ;
        }
        System.out.print("第"+(no+1)+"链表信息为: ");
        Emp curEmp = head;
        while (true) {
            System.out.printf("id=%d name=%s\t",curEmp.id,curEmp.name);
            // 说明链表在最后一个节点
            if(curEmp.next == null) {
                break;
            }

            curEmp = curEmp.next;
        }
        System.out.println();
    }

}


class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

