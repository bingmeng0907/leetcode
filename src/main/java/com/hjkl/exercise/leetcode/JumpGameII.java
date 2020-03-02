package com.hjkl.exercise.leetcode;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int step = 0, curEnd = 0, curMax = 0;
        for(int i=0; i<nums.length-1; i++) {
            curMax = Math.max(curMax, i+nums[i]);
            if (i == curEnd) {
                step++;
                curEnd = curMax;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        new JumpGameII().jump(nums);
    }
}
