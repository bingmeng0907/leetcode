package com.hjkl.exercise.leetcode;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return 1;
        //[0,0,1,1,1,2,2,3,3,4],
        int idx = 1;
        for(int i=1; i<nums.length;i++) {
            if (nums[i] != nums[i-1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = new RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
        System.out.println(i);
    }
}
