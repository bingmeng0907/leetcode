package com.hjkl.exercise.leetcode;

public class FindLeftBound {
    private int find(int[] nums, int t) {
        int l = 0, r = nums.length;
        while(l < r) {
            int m = l + (r-l)/2;
            if(nums[m] > t) {
                r = m;
            } else if(nums[m] < t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,9};
        System.out.println(new FindLeftBound().find(nums, 2));
        System.out.println(Integer.highestOneBit(16));
    }
}
