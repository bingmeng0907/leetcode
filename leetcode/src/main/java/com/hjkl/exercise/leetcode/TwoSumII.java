package com.hjkl.exercise.leetcode;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = {-1, -1};
        if (numbers == null || numbers.length <= 0) return ret;
        int i=0, j=numbers.length-1;
        while(i<j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                ret[0] = i+1;
                ret[1] = j+1;
                return ret;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return ret;
    }
}
