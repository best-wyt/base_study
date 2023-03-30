package com.wang.test.动态规划;

/**
 * @author wyt
 * @date 2023/3/15 12:44
 * @description 最长子序列长度
 */
public class LongestCommonSequenceLength {

    public static void main(String[] args) {

    }


    public static int getLongest (String text1 , String text2) {
        // 表示长度
        int x = text1.length();
        // 表示深度
        int y = text2.length();

        int[][] arr = new int[y+1][x+1];

        for (int i = 1; i <= y ; i++) {
            char char2 = text2.charAt(i-1);
            for (int j = 1; j <=x ; j++) {
                char char1 = text1.charAt(j-1);
                if (char1 == char2) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j] , arr[i][j-1]);
                }
            }
        }

        return arr[y][x];

    }


}
