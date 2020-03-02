package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null) return -1;
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        // 1 2 3 5 6 7 8 9 9 9
        new FindtheDuplicateNumber().findDuplicate(nums);
    }
}
