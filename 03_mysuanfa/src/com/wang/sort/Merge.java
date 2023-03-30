package com.wang.sort;

import java.util.Arrays;

/**
 * @author wyt
 * @date 2023/3/12 15:51
 * @description
 */
public class Merge {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 1, 2, 4 , 23,34,45,1,34,6,3,1,7,9,2,45,67,23,9,4,2,7};
        int[] tempArr = new int[arr.length];
        sort(arr , tempArr , 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort (int[] arr , int[] tempArr, int low , int high) {
        // 如果最小的索引=最大的索引说明已经拆分成了单个元素
        if (high <= low) {
            return;
        }
        // 求出中间索引
        int mid = (low + high) >> 1;
        // 将最小索引到中间索引进行排序
        sort(arr ,tempArr , low , mid);
        // 将中间索引到最大索引进行排序
        sort(arr , tempArr,mid + 1 , high);

        // 合并排序后的数据
        merge (arr ,tempArr , low ,mid , high);

    }

    public static void merge (int[] arr ,int[] tempArr, int low , int mid , int high) {
        int lowIndex = low;
        int highIndex = mid + 1;
        int index = low;

        // 分别将low到mid间的数据和mid+1到high间的数据合并到辅助数组
        while (lowIndex <= mid && highIndex <= high) {
            if (arr[lowIndex] < arr[highIndex]) {
                tempArr[index++] = arr[lowIndex++];
            } else {
                tempArr[index++] = arr[highIndex++];
            }
        }

        // 如果low到mid间的数据还没合并完
        while (lowIndex <= mid) {
            tempArr[index++] = arr[lowIndex++];
        }
        // 如果mid+1到high间的数据没合并完
        while (highIndex <= high) {
            tempArr[index++] = arr[highIndex++];
        }
        // 将辅助数组中的数据复制到原数组
        for (int i = low; i <= high ; i++) {
            arr[i] = tempArr[i];
        }

    }


}
