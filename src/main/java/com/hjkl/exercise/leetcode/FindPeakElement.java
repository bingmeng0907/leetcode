package com.hjkl.exercise.leetcode;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        //[1,2,1,3,5,6,4]
        if (nums == null || nums.length <= 0) return 0;
        int l = 0, h = nums.length-1;
        while(l < h) {
            int m = l + (h-l)/2;
            if (nums[m] < nums[m+1]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }
}
