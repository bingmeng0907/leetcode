package com.hjkl.exercise.leetcode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        //2,3,1,1,4
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            if (max < i) return false;
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
