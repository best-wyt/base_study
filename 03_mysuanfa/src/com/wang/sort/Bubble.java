package com.wang.sort;

import java.util.Arrays;

/**
 * @author wyt
 * @date 2023/3/11
 * @description 冒泡排序法
 */
public class Bubble {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        // 每循环一次把已排序的排除掉，不参与排序
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.println("i=" + i);
            // 每次循环完后选出最大的一个放在最后
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
