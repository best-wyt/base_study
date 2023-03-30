package com.wang.sort;

import java.util.Arrays;

/**
 * @author wyt
 * @date 2023/3/12 14:58
 * @description
 */
public class Shell1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 1, 2, 4, 23, 34, 45, 1, 34, 6, 3, 1, 7, 9, 2, 45, 67, 23, 9, 4, 2, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        int h = 1;
        while (h < arr.length >> 1) {
            h = (h << 1) + 1;
        }

        while (h >= 1) {

            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j - h] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }else {
                        break;
                    }
                }
                System.out.println(Arrays.toString(arr));
            }

            h = h >> 1;

        }


    }


}
