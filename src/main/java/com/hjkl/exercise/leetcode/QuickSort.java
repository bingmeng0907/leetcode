package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] nums, int l, int r) {
        if(l < r) {
            int pivot = partition(nums, l, r);
            quickSort(nums, l, pivot-1);
            quickSort(nums, pivot+1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        for(int i=l; i<r; i++) {
            if(nums[i]<= nums[r]) {
                swap(nums, l++, i);
            }
        }
        swap(nums, l, r);
        return l;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {9,3,5,1,2,10,7};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}