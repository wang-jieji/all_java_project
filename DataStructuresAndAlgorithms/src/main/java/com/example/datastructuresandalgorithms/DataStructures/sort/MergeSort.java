package com.example.datastructuresandalgorithms.DataStructures.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description 6  归并排序
 * @Author WJJ
 * @Date 19/2/2023 18:06
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 4, 5, 8, 1, 3, 6, 2};

        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {

        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int tempIndex = 0;

        while (i <= mid && j <= right) {
            if (arr[i] >= arr[j]) {
                temp[tempIndex] = arr[j];
                j += 1;
                tempIndex += 1;
            } else {
                temp[tempIndex] = arr[i];
                i += 1;
                tempIndex += 1;
            }
        }

        //判断左边的是否还存在未比较数据
        while (i <= mid) {
            temp[tempIndex] = arr[i];
            i += 1;
            tempIndex += 1;
        }

        //判断右边的是否还存在未比较数据
        while (j <= right) {
            temp[tempIndex] = arr[j];
            j += 1;
            tempIndex += 1;
        }

        int t = 0;
        int templeft = left;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            t += 1;
            templeft += 1;
        }


    }
}
