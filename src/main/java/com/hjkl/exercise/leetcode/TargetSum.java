package com.hjkl.exercise.leetcode;

public class TargetSum {
    /*
        sum(p) - sum(n) = target
        sum(p) + sum(n) + sum(p) - sum(n) = target + sum;
        sum(p) = (target+sum)/2;

     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        return sum < S || ((sum+S) % 2 != 0) ? 0 : subset(nums, (sum+S)>>1);
    }
    private int subset(int[] nums, int t) {
        int[] dp = new int[t+1];
        dp[0] = 1;
        for(int n : nums) {
            for(int i = t; i>=n ; i--) {
                dp[i] += dp[i-n];
            }
        }
        return dp[t];
    }
}
