package com.wang.sort;


import java.util.Arrays;

/**
 * @author wyt
 * @date 2023/3/11 19:37
 * @description shell 排序 shell排序是相当于把一个数组中的所有元素分成几部分来排序；
 * 先把几个小部分的元素排序好，让元素大概有个顺序，最后再全面使用插入排序。
 * 一般最后一次排序都是和上面的插入排序一样的；
 */
public class Shell {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 1, 2, 4 , 23,34,45,1,34,6,3,1,7,9,2,45,67,23,9,4,2,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int h = 1;
        // 如果对2的倍数求余 x & (y-1)
        // int i = 7 & (2 - 1) ==> int j = 7 % 2; 结果相同
        // 求出第一次分组后的索引
        while (h < arr.length >> 1) {
            h = h << 1 + 1;
        }

        while (h > 0) {
            // 对分组后的数组进行【拟】插入排序,只是将每组数尽量按照从小到大排序
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    } else {
                        break;
                    }

                }
                System.out.println(Arrays.toString(arr));
            }
            // 逐渐将分组变为 1，即变为完整的插入排序
            h = h >> 1;
        }


    }

}
