package com.example.datastructuresandalgorithms.DataStructures.recursion;

import java.util.Arrays;

/**
 * @Description 用递归回溯解决8皇后问题（两个皇后不在同一个列，同一行，同一个斜线上）
 * @Author WJJ
 * @Date 20/7/2022 下午11:47
 **/
public class Queen8 {

    private static final int MAX = 8 ;
    // 先定义一个一维数组，存放每个解法中皇后的位置（索引代表棋盘的行，也代表是第几个皇后；value值代表棋盘中的列）。这是规范
    // 但由于索引是从0开始，所以在棋盘上 索引+1  才表示棋盘中的行和第几个皇后。比如 arr = {0 , 4 , 7 , 5 , 2 , 6 , 1, 3};
    // arr数组中第一个数表示0 第一个皇后的位置在 第一行第一列
    private static int[] arry = new int[MAX];

    public static void main(String[] args) {
        recordLocation(0);


    }

    // 存放当前第n个皇后的位置
    public static void recordLocation(int n) {
        // 因为习惯把n从0开始，所以当n==MAX时就代表n个棋子以及放完了，只有棋子都放完了，才代表在某个摆法中八个棋子都放在正确位置，也才能输出。
        // 如果不能放置所有棋子，代码也运行不到这里，也就是过滤掉了所有不正确的摆法。因为可能在第五个或者第六个棋子就开始回溯，直到八个棋子都摆满或者回溯到第一位棋子重新摆放
        if(n == MAX) {
            print();
            return;
        }

        // n即代表第几个皇后，也代表是数组中的索引,也就是行。所以遍历每一个列，
        for(int  column = 0 ; column < MAX ; column++) {
            // 先将棋子放在第n个棋子放在第n行的第一个列上
           arry[n] = column;
           // 然后判断棋子在这个列上是否与其他冲突
           if(isConflict(n)) {
                // 不冲突，就开始放下一个棋子，因为n也代表第几行，所以n+1即代表第n个棋子，也代表第n+1行，所以不会和第n个棋子在同一行
               recordLocation(n+1);
           }
           // 如果冲突，不做处理，因为循环会跳到开始，column会+1，把棋子放在下一列，重复比较
        }
    }

    /**
     * @Author WJJ
     * @Description 判断第n个皇后与之前所有皇后的位置是否冲突
     * @Date 下午11:57 20/7/2022
     * @Param  n 代表第几个皇后
     * @return 冲突返回false 否则为true
     **/
    public static boolean isConflict(int n) {
        for(int i = 0 ; i< n ; i++) {
            // 判断当前皇后是否和之前的皇后在同一列和同一条斜线上
            // arry[n] == arry[i] 因为arry数组存的盘就是棋上的列，所以只要是相等，就代表两个棋子在同一个列上
            // Math.abs(n - i) == Math.abs(arry[n] - arry[i]) 这里是运用了直线的斜率来判断是否在同一直线上
            // 上面可以表达为 n-i/(arry[n] - arry[i]) = 1或-1，所以要取绝对值 ，也即代表斜率为1或-1。(高中数学，忘记请再复习)
            if(arry[n] == arry[i] || Math.abs(n - i) == Math.abs(arry[n] - arry[i])) {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        for(int  i = 0 ; i < arry.length ; i++) {
            System.out.print(arry[i]+" ");
        }
        System.out.println();
    }
}
