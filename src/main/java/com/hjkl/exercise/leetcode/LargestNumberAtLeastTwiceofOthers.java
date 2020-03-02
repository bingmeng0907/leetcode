package com.hjkl.exercise.leetcode;

public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        // 3, 6, 1, 0
        int maxIdx = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        for(int i=0; i<nums.length; i++) {
            if (i == maxIdx) continue;
            if (nums[i]*2 > nums[maxIdx]) return -1;
        }
        return maxIdx;
    }
}
