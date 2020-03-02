package com.hjkl.exercise.leetcode;

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        // [2,2,2,0,1]
        int l = 0, h = nums.length-1;
        while(l <= h) {
            int m = l + (h-l)/2;
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else if (nums[m] < nums[h]) {
                h = m;
            } else {
                h--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        new FindMinimuminRotatedSortedArrayII().findMin(nums);
    }
}
