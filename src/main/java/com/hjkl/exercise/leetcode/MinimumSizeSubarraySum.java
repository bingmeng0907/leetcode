package com.hjkl.exercise.leetcode;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int l=0,r=0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(r<nums.length) {
            sum += nums[r++];
            while(sum >= s) {
                len = Math.min(len, r-l);
                sum -= nums[l++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
