package com.wang.test.数组;

import java.util.Arrays;

/**
 * @author wyt
 * @date 2023/3/18 17:04
 * @description
 */
public class Test1 {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        merge(a , 3 , b , 3);
        System.out.println(Arrays.toString(a));
    }


    public static void merge(int A[], int m, int B[], int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, z = 0;
        while (i < m && j < n) {

            if (A[i] > B[j]) {
                temp[z++] = B[j++];
            } else {
                temp[z++] = A[i++];
            }

        }
        while (i < m) {
            temp[z++] = A[i++];
        }
        while (j < n) {
            temp[z++] = B[j++];
        }
        for (int x = 0 ; x < z ; x++) {
            A[x] = temp[x];
        }
    }

}
