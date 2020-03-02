package com.hjkl.exercise.leetcode;


import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int ret = 0;
        for(int i=n-1; i>=2; i--) {
            int l = 0, r = i-1;
            while(l<r) {
                if (nums[l] + nums[r] > nums[i]) {
                    ret += r-l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ret;
    }
}
