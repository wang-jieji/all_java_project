package com.example.datastructuresandalgorithms.DataStructures.linkedlist;

/**
 * @Description 环形链表 解决约瑟夫问题
 * @Author WJJ
 * @Date 7/7/2022 下午6:13
 **/
public class CirclelinkedListDemo {
    public static void main(String[] args) {
        Boy boy1 = new Boy(1,"张三");
        Boy boy2 = new Boy(2,"李四");
        Boy boy3 = new Boy(3,"王五");
        Boy boy4 = new Boy(4,"赵六");
        Boy boy5 = new Boy(5,"胜七");
        Boy boy6 = new Boy(6,"周八");
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(boy1);
        circleLinkedList.add(boy2);
        circleLinkedList.add(boy3);
        circleLinkedList.add(boy4);
        circleLinkedList.add(boy5);
        circleLinkedList.add(boy6);
       // circleLinkedList.list();

        circleLinkedList.josephGame(6,2);

    }

}

class CircleLinkedList{
    // 第一个节点
    private Boy fristBoy;

    /**
     * @Author WJJ
     * @Description 添加节点，构成环形链表
     **/
    public void add(Boy newBoy) {
        if(fristBoy == null) {
            fristBoy = new Boy(newBoy.getNo(),newBoy.getName());
            fristBoy.setNext(fristBoy) ;
            return;
        }
        Boy curBoy = fristBoy;
        while (true) {
            // 当前节点的下一个节点指向首节点，说明已经循环到了最后一个节点
            if(curBoy.getNext() == fristBoy) {
                curBoy.setNext(newBoy);
                // 将新节点的下一个节点指向首节点
                newBoy.setNext(fristBoy);
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * @Author WJJ
     * @Description 约瑟夫问题 从任意一个节点 startNo开始，按照指定数字 countNum 取出节点，并从取出节点的下一位开始重新循环,直到只剩下一个节点为止
     **/
    public void josephGame(int startNo , int countNum) {
        // 校验数字是否是正确数字，不能小于零 不想写
        // 创建一个辅助节点，用于删除指定节点
        Boy helperBoy = fristBoy;
        // 循环链表，找到链表的最后一个节点，并引用给helperBoy
        while(true) {
           if(helperBoy.getNext() == fristBoy) {
               break;
           }
           helperBoy = helperBoy.getNext();
        }
        // 先将指针指向指定节点开始
        for(int i = 0 ; i < startNo - 1 ; i++) {
            fristBoy = fristBoy.getNext();
           helperBoy = helperBoy.getNext();
        }
        // 再根据指定数字，循环取出节点，直到只剩下一个
        while (true) {
            if(fristBoy == helperBoy) {
                break;
            }
            // 将指向首个节点的指针按照指定数字移 num -1 动到 指定节点
            for(int i = 0 ; i < countNum -1 ; i++) {
                fristBoy = fristBoy.getNext();
                helperBoy = helperBoy.getNext();
            }
            System.out.println("取出的节点是 = " + fristBoy);
            // 将fristBoy节点指向 要取出的节点的后一位
            fristBoy = fristBoy.getNext();
            helperBoy.setNext(fristBoy);

            list();
        }
    }

    public void list() {
        if(fristBoy == null) {
            System.out.println("链表为空，不能遍历~~");
            return;
        }

        Boy curBoy = fristBoy;
        while (true) {
            System.out.printf("姓名: %s 编号：%d\n",curBoy.getName(),curBoy.getNo());
            if(curBoy.getNext() == fristBoy) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}

class Boy{
    private int no;
    private String name;
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no , String name) {
        this.no = no ;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
