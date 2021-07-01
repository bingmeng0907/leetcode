package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] nums) {
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {9,3,5,1,2,10,7};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
