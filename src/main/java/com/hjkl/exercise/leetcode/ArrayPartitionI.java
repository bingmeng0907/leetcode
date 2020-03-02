package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        /*
            {1,4,3,2} -> {1,2,3,4} ->min(1,2)+min(3,4) = 4(max)
            {9,10,3,7,15,8} -> {3,7,8,9,10,15} -> min(3,7) + min(8,9) + min(10,15) = 21(max)
         */
        if (nums == null || nums.length <= 0) return 0;
        int sum = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length;) {
            sum += nums[i];
            i += 2;
        }
        return sum;
    }
}
