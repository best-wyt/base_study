package com.wang.sort;

import java.util.Arrays;

/**
 * @author wyt
 * @date 2023/3/12 14:48
 * @description
 */
public class Insertion1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort (int[] arr) {

        for (int i = arr.length - 1; i > 0 ; i--) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j -1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

    }


}
