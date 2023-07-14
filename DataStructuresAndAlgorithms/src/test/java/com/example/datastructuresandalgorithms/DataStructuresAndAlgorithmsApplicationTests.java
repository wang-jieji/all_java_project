package com.example.datastructuresandalgorithms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DataStructuresAndAlgorithmsApplicationTests {

    @Test
    void contextLoads() {
        int n = 100 ;
        int sum =  ( 1 + n ) * n / 2 ;
        //System.out.printf("%d",sum);

        int[] L = {1,7,11,47,0,0};
        int l = 4 ;

        //listInsert(L,l,5,8);
        System.out.println(listremove(L,l,2));
    }

    @Test
    void listInsert(int[] L ,int l, int i,int num){

        System.out.println(Arrays.toString(L));


        // 在顺序线性表3的位置插入数据9，插入算法的思路
        // 1、如果插入位置不合理，抛出异常
        // 2、如果线性表长度大于数组长度，则抛出异常或动态扩容
        // 3、从最后一个元素开始向前遍历到第i个位置，分别将它们都向后移一个位置；
        // 4、将要插入元素填入位置i处
        // 5、表长加1
        if (i < 1 || i > L.length ) {
            throw new RuntimeException("超出线性表的长度");
        }

        if (l == L.length ) {
            throw new RuntimeException("线性表已满");
        }

        if(l <= L.length) {
            for(int k = l ; k >= i -1 ; k-- ) {
                L[k+1] = L[k];
            }
        }
        L[i-1] = num;
        l++;
        System.out.println(Arrays.toString(L));
    };

    // 线性表删除
    int listremove(int[] L ,int l, int i){
        //1、如果删除位置不合理，抛出异常
        //2、取出删除元素
        //3、从删除元素开始遍历到最后一个元素位置，分别将它们都向前移动一个位置；
        //4、表长减一
        if (i < 1 || i > L.length ) {
            throw new RuntimeException("删除位置超出线性表");
        }
        int eleme = 0 ;
        // 如果删除位置不是在最后一位
        if (i < L.length ) {
            eleme = L[i-1];
            for (int k = i-1 ; k < l ; k++) {
                L[k] = L[k+1];
            }
        }

        System.out.println("L = " + Arrays.toString(L));
        return eleme;
    }

    @Test
    public void TestDemo(){
        String value = "123";
        char c1 = value.substring(0,1).charAt(0);
        char c2 = value.substring(1,2).charAt(0);
        char c3 = value.substring(2,3).charAt(0);
        System.out.println(c1+"/"+c2+"/"+c3);
    }


}
