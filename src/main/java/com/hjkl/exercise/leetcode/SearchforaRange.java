package com.hjkl.exercise.leetcode;

public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
       int[] ret = {-1, -1};
       if (nums == null || nums.length <= 0) return ret;
       int l = 0, h = nums.length - 1;
       while(l < h) {
           int m = l + (h-l)/2;
           if (nums[m] < target) {
               l = m + 1;
           } else {
               h = m;
           }
       }
       if (nums[l] != target) {
           return ret;
       }
       ret[0] = l;
       h = nums.length -1;
       while(l < h) {
           int m = l + (h-l)/2 + 1;
           if (nums[m] > target) {
               h = m - 1;
           } else {
               l = m;
           }
       }
       ret[1] = h;
       return ret;
    }
}
