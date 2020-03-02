package com.hjkl.exercise.leetcode;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        // [4,5,6,7,0,1,2]
        if (nums == null || nums.length <= 0) return -1;
        int l = 0, h = nums.length - 1;
        while(l < h) {
            int m = l + (h-l)/2;
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }
}
