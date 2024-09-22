package com.wang.test.str;

import java.util.Arrays;

/**
 * @author wyt
 * @date 2024/5/16 22:13
 * @description
 */
public class KMPSonStrStartIndex {

    public static void main(String[] args) {

        String sonStr = "aabaaf";
        System.out.println(Arrays.toString(getNextArr(sonStr)));

    }


    public static int[] getNextArr(String sonStr) {

        int[] nextArr = new int[sonStr.length()];
        // 初始化
        nextArr[0] = 0;
        // 前缀最后一个字符所在索引位置
        int j = 0;
        // i : 后缀最后一个字符所在索引位置
        for (int i = 1; i < sonStr.length(); i++) {

            // 如果前缀最后一个字符 ！= 后缀最后一个字符
            // 那么前缀最后一个字符向前移动
            // 移动到的位置 = next[j - 1] 直到 前缀最后一个字符 == 后缀最后一个字符 或 前缀最后一个字符索引 = 0

            while (j != 0 && sonStr.charAt(j) != sonStr.charAt(i)) {
                j = nextArr[j - 1];
            }

            // 如果 前缀最后一个字符 == 后缀最后一个字符
            // 那么 前缀最后一个字符 + 1
            if (sonStr.charAt(j) == sonStr.charAt(i)) {
                j ++;
            }

            // 给nextArr[i]赋值为j
            nextArr[i] = j;
        }
        return nextArr;
    }


}
