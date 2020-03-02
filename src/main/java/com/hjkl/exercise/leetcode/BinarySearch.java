package com.hjkl.exercise.leetcode;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;
        int left = 0, right = nums.length-1;
        while(left<=right) {
            int middle = left + (right-left)/2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle-1;
            }
        }
        return -1;
    }
}
