package com.example.datastructuresandalgorithms.DataStructures.sort;

import java.util.Arrays;

/**
 * @Description 3、插入排序
 * @Author WJJ
 * @Date 23/7/2022 下午3:19
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {101,34,200,40,50,3,-1,89};


        insertSort(array);
        System.out.println("args = " + Arrays.toString(array));
    }

    //{101,34,200,40,50,3};
    public static void insertSort(int[] array) {
        // 插入排序常规都是从第二个数开始，与前一个数比较，再把数插入到对应的排序位置
        for (int i = 1; i < array.length; i++) {
            // 要插入的值，其实就是要跟前一位比较的值，比如{101，34}中，就是34
            int insertValue = array[i];
            // 待插入的索引，就是被比较的数的索引，比如 {101，34} 中就是101的索引值。i是当前值的索引，减一就是它前一位的索引。而且规定了i的取值范围是从1开始，所以不会又数组越界问题
            int toBeInsertIndex = i - 1 ;
            // 当要插入的值比前一位值小，说明要插入的值位置不正确，需要和前一位相互调换
            while (toBeInsertIndex >= 0 && insertValue < array[toBeInsertIndex]) {
                array[toBeInsertIndex+1] = array[toBeInsertIndex];
                toBeInsertIndex--;
            }
            // 当退出循环时，说明找到了插入位置
            array[toBeInsertIndex+1] = insertValue;


        }
    }
}
