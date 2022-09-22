package com.example.datastructuresandalgorithms.DataStructures.recursion;

import java.util.Arrays;

/**
 * @Description 1 用递归解决迷宫回溯问题
 * @Author WJJ
 * @Date 19/7/2022 下午6:14
 **/
public class Maze {

    public static void main(String[] args) {
        //先用二维数组模拟一个迷宫
        int[][] maze = new int[8][7];

        //设置迷宫左右两边的围墙
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        //设置迷宫上下两边的围墙
        for (int i = 0; i < 6; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        //设置挡板
        maze[3][1] = 1;
        maze[3][2] = 1;


        setWay(maze,1,1);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * @return 如果找到通路 返回true ,否则返回false
     * @Author WJJ
     * @Description 使用递归回溯给小球找路 约定：当 maze[i][j]=0表示该点没有走过；当为1时表示是墙；当为2是表示通路可以走；当为3时表示该点已经走过但走不通
     * 走迷宫策略 ：下 ——> 右 ——> 上 ——> 左 ，如果该点走不通，再回溯
     * @Param maze 表示地图
     * @Param i 表示从哪行开始
     * @Param j 表示从哪列开始
     **/
    public static boolean setWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            if (maze[i][j] == 0) {
                maze[i][j] = 2;

                if (setWay(maze, i + 1, j)) {  // 尝试往下走
                    return true;
                } else if (setWay(maze, i, j + 1)) { // 尝试往右走
                    return true;
                } else if (setWay(maze, i - 1, j)) { // 尝试往上走
                    return true;
                } else if (setWay(maze, i, j - 1)) { // 尝试往左走
                    return true;
                } else {
                    maze[i][j] = 3; //表示该点是死路
                    return false;
                }
            } else {
                return false;
            }
        }

    }

}
