package com.example.datastructuresandalgorithms.DataStructures.sort;

import java.util.Arrays;

/**
 * @Description 1、冒泡排序:依次比较相邻的值，若发现逆序则交换，如果一趟比较下来没有进行交换，就说明序列有序
 * @Author WJJ
 * @Date 22/7/2022 下午4:49
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3,9,-1,10,20,0,2,40};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * @Author WJJ
     * @Description 冒泡排序
     * @Date 下午5:25 22/7/2022
     * @Param  * @param null
     * @return {@link null}
     **/
    public static void bubbleSort(int[] array) {
        // 判断此次循环是否没有排序变化
        boolean flag = false;
        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = 0; j < array.length - 1 - i ; j++) {
                if(array[j] > array[j+1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(!flag) {
                break;
            } else {
                // 如果又发生排序，需要将值初始化,否则当下一次没有发生排序，但标志符依然是记录成了发生了排序
                flag = false;
            }
        }
    }
}
