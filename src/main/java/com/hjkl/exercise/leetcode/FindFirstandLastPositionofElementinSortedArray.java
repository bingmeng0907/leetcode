package com.hjkl.exercise.leetcode;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if (nums == null || nums.length <= 0) return ret;
        int l = 0, r = nums.length-1;
        while(l < r) {
            int m = l + (r-l)/2;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (nums[l] != target) return ret;
        ret[0] = l;
        r = nums.length-1;
        while(l < r) {
            int m = l + (r-l)/2;
            if (nums[m] > target) {
                r = m -1;
            } else {
                l = m;
            }
        }
        ret[1] = r;
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
    }
}
