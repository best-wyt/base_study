package com.wang.test.stack;

/**
 * @author wyt
 * @date 2024/6/4 20:17
 * @description
 */
public class Test1 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums , val));

    }

    public static int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] != val) {
                left++;
            }
            while (left < right && nums[right] == val) {
                right--;
            }
            if (left != right) {
                nums[left] = nums[right];
            }
            left++;
            right--;
        }
        return right+1;
    }

}
