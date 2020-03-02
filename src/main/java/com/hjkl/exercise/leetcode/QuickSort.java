package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums) {
        qSort(nums, 0, nums.length-1);
    }
    private static void qSort(int[] nums, int lo, int hi) {
        if (lo<hi) {
            int pivot = partition(nums, lo, hi);
            qSort(nums, lo, pivot-1);
            qSort(nums, pivot+1, hi);
        }
    }

    private static int partition(int[] nums, int lo, int hi) {
        for(int i=lo; i<hi; i++) {
            if (nums[i]<=nums[hi]) {
                swap(nums, lo++,i);
            }
        }
        swap(nums, lo, hi);
        return lo;
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