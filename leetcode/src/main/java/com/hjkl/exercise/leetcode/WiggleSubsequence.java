package com.hjkl.exercise.leetcode;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int up = 1, down = 1;
        for(int i=1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                down = up + 1;
            } else if (nums[i] > nums[i-1]) {
                up = down + 1;
            }
        }
        return Math.max(up, down);
    }
}
