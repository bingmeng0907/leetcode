package com.hjkl.exercise.leetcode;

public class ReverseSubarrayToMaximizeArrayValue {
    public int maxValueAfterReverse(int[] nums) {
        int res = 0, diff = 0;
        int l = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<l-1; i++) {
            res += Math.abs(nums[i]-nums[i+1]);
            // max(min(c,d) for any c,d) and min(max(a,b) for any a,b)
            min = Math.min(min, Math.max(nums[i], nums[i+1]));
            max = Math.max(max, Math.min(nums[i], nums[i+1]));
        }
        diff = Math.max(diff, 2*(max-min));
        for(int i=1; i<l-1; i++) {
            diff = Math.max(diff, Math.abs(nums[i+1]-nums[0]) - Math.abs(nums[i+1]-nums[i]));
            diff = Math.max(diff, Math.abs(nums[l-1]-nums[i-1]) - Math.abs(nums[i]-nums[i-1]));
        }
        return res + diff;
    }
}
