package com.example.datastructuresandalgorithms.DataStructures.sort;

import java.util.Arrays;

/**
 * @Description 2、选择排序
 * @Author WJJ
 * @Date 22/7/2022 下午6:11
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {101,34,119,1,-1,90,123,5,300,0,-3};
        selectSort(array);
        System.out.println("args = " + Arrays.toString(array));

    }

    public static void selectSort(int[] array) {
        
        int min = 0 ;
        int minIndex = 0 ; 
        
        for (int i = 0; i < array.length -1 ; i++) {
            min = array[i];
            minIndex = i;
            for (int j = i+1 ; j < array.length ; j++) {
                if(min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }
}
