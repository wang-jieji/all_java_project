package com.example.datastructuresandalgorithms.DataStructures;

import java.io.*;
import java.net.URLDecoder;
import java.util.Arrays;

/**
 * @Description 稀疏数组
 * @Author WJJ
 * @Date 2022/6/18 18:11
 **/
public class SparseArraysDemo {
    public static void main(String[] args) {
        // 定义一个二维数组
        int[][] twoDimesionalArrays = new int[11][11];
        twoDimesionalArrays[1][2] = 1;
        twoDimesionalArrays[2][3] = 2;
        twoDimesionalArrays[8][7] = 9;

        for (int[] array : twoDimesionalArrays) {
            for (int data : array) {
                System.out.printf("%d\t", data);
            }
            System.out.printf("\n");
        }

        // 将二维数组转为稀疏数组的思路
        int sum = 0;
        //1、遍历原始的二维数组，得到有效数据的个数
        for (int i = 0; i < twoDimesionalArrays.length; i++) {
            for (int j = 0; j < twoDimesionalArrays[i].length; j++) {
                if (twoDimesionalArrays[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2、根据sum 就可以创建 稀疏数组 sparse int[sum+1][3]
        int[][] sparseArrays = new int[sum + 1][3];

        //3、将二维数组的有效数据存入到 稀疏数组 中
        sparseArrays[0][0] = 11;
        sparseArrays[0][1] = 11;
        sparseArrays[0][2] = sum;

        int count = 0;
        for (int i = 0; i < twoDimesionalArrays.length; i++) {
            for (int j = 0; j < twoDimesionalArrays[i].length; j++) {
                if (twoDimesionalArrays[i][j] != 0) {
                    count++;
                    sparseArrays[count][0] = i;
                    sparseArrays[count][1] = j;
                    sparseArrays[count][2] = twoDimesionalArrays[i][j];

                }
            }
        }

        // 输出稀疏数组
        for (int[] array : sparseArrays) {
            for (int data : array) {

                System.out.printf("%d\t", data);
            }
            System.out.printf("\n");
        }

      FileWriter fileWriter = null;
        try {
            // 将稀疏数组 存入 磁盘txt
            File file = new File("sparseArrays.txt");
            // 如果文件不存在就创建
            if (!file.exists()) {
                file.createNewFile();
            }

            fileWriter = new FileWriter(file)  ;

            for (int[] array : sparseArrays) {
                for (int data : array) {
                    fileWriter.write(data+""+"\t");

                }
                fileWriter.write("\n");

            }
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        // 将稀疏数组 还原为 二维数组
        int[][] originalArrays = new int[sparseArrays[0][0]][sparseArrays[0][1]];

        for (int i = 1; i <= sum; i++) {
            int row = sparseArrays[i][0];
            int col = sparseArrays[i][1];
            int value = sparseArrays[i][2];
            originalArrays[row][col] = value;
        }

        // 遍历还原后的二维数组
        for (int[] array : originalArrays) {
            for (int data : array) {
                System.out.printf("%d\t", data);
            }
            System.out.printf("\n");
        }
    }


}
