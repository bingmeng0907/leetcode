package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        /*
            Input: [1,2,3,4,5,6,7] and k = 3
            ->[4,3,2,1,7,6,5]
            ->[5,6,7,1,2,3,4]
            Output: [5,6,7,1,2,3,4]
         */
        if (nums == null || nums.length <= 0) return;
        k = k % nums.length;
        int l = 0, r = nums.length - k - 1;
        while(l<r) {
            swap(nums, l++, r--);
        }
        l = nums.length -k;
        r = nums.length - 1;
        while(l < r) {
            swap(nums, l++, r--);
        }
        l = 0;
        r = nums.length - 1;
        while(l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new RotateArray().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
