package com.example.datastructuresandalgorithms.DataStructures.sort;

import java.util.Arrays;

/**
 * @Description 4.希尔排序
 * @Author WJJ
 * @Date 23/7/2022 下午6:44
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8,9,1,7,2,3,5,4,6,0};
        shellSort(array);
        System.out.println("args = " + Arrays.toString(array));

    }

    /**
     * @Author WJJ
     * @Description 希尔排序(移位法)
     **/
    public static void shellSort(int[] array) {

        for(int gap = array.length / 2 ; gap > 0 ; gap/=2 ) {
            //从gap个元素开始，逐个对其所在的组进行直接插入排序
            for(int i = gap ; i < array.length ; i++) {
                int j = i;
                int temp = array[j];
                if(array[j] < array[j-gap]) {
                    while (j-gap >= 0 && temp < array[j-gap] ){
                        // 移位
                        array[j] =  array[j-gap];
                        j-=gap;
                    }
                    // 当退出while后，就给temp找到插入的位置
                    array[j] =temp;
                }
            }
        }

    }
}
