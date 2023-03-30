package com.wang.sort;


import java.util.Arrays;

/**
 * @Author: wyt
 * @Description: 插入排序法
 * @DateTime: 2023/3/11 19:14
 */
public class Insertion {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 从最右边开始排序
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = i - 1; j < arr.length - 1; j++) {
                // 从当前位置一直比较，直到遇到比自己大的
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }

            }
        }

    }
}
