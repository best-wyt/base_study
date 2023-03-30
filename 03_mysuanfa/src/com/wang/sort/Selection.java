package com.wang.sort;

import java.util.Arrays;

/**
 * @Author: wyt
 * @Description: 选择排序法
 * @DateTime: 2023/3/11 18:10
 */
public class Selection {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }

        }

    }


}
