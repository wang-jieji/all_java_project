package com.example.datastructuresandalgorithms.DataStructures.sort;

import java.util.Arrays;

/**
 * @Description 5 快速排序
 * @Author WJJ
 * @Date 25/7/2022 下午6:22
 **/
public class QuickSort {
    public static void main(String[] args) {

        int[] array = {1,6,5,4,7,2,3};
        quickSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));

    }


    /**
     * 快速排序
     *
     * @param array 数组
     * @param left  左下标
     * @param right 右下标
     */
    public static void quickSort(int[] array,int left,int right){
        // 左下标

        int l = left;
        // 右下标
        int r = right;
        // 中轴值
        int pivot = array[(left + right) / 2];
        // 临时变量
        int temp = 0 ;
        // 循环遍历，将比pivot值小的放在左边
        while(l <= r) {
            //在pivot左边循环，直到找到比pivot的值小的数才退出
            while (array[l] < pivot) {
                l+=1;
            }

            //在pivot右边循环，直到找到比pivot的值大的数才退出
            while (array[r] > pivot) {
                r-=1;
            }

            // l > r 说明左边的值都比pivot值小，右边的值都比pivot值大
            if(l>=r) {
                break;
            }

            // 将pivot左右两边的值互相交换
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            // 交换后，array[l] == pivot, 相等r--, 前移
            if(array[l] == pivot) {
                r-=1;
            }

            // 交换后，array[r] == pivot, 相等l++, 后移
            if(array[r] == pivot) {
                l+=1;
            }

        }

        if(l == r) {
            l+=1;
            r-=1;
        }

        // 向左递归
        if(left < r) {
            quickSort(array,left,r);
        }

        if(right > l) {
            quickSort(array,l,right);
        }


    }
}
