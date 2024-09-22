package com.wang.mytest;

import java.util.Arrays;

/**
 * @author wyt
 * @date 2024/8/8 19:38
 * @description
 */
public class MyTest {


    public static void main(String[] args) {
        int[] arrA = {1 , 3 ,5};
        int[] arrB = {2 , 4 , 6};
        System.out.println(Arrays.toString(mergeArray(arrA , arrB)));
    }


    public static int[] mergeArray(int[] arrA, int[] arrB) {

        int[] result = new int[arrA.length + arrB.length];
        int index = 0;
        int x = 0;
        for (int i = 0; i < arrA.length; i++) {
            if (x == arrB.length || arrA[i] >= arrB[x]) {
                result[index++] = arrA[i];
            } else {
                while (x < arrB.length && arrB[x] > arrA[i]) {
                    result[index++] = arrB[x++];
                }
            }
        }

        while (x < arrB.length) {
            result[index ++] = arrB[x++];
        }

        return result;

    }


}
