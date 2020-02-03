package com.hjkl.exercise.leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int[] left = new int[height.length];
        left[0] = height[0];
        for(int i=1; i<height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        int[] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }
        int ret = 0;
        for(int i=0; i<height.length; i++) {
            ret += Math.min(left[i], right[i]) - height[i];
        }
        return ret;
    }
}
