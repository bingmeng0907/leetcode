package com.hjkl.exercise.leetcode;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        //[4,5,6,7,0,1,2]
        if (nums == null || nums.length <= 0) return -1;
        int l = 0, h = nums.length - 1;
        while(l<=h) {
            int m = l + (h-l)/2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target  && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {3, 1};
        new SearchinRotatedSortedArray().search(nums, 1);
    }
}
