package com.hjkl.exercise.leetcode;

public class StoneGameIII {
    public String stoneGameIII(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n+1];
        for(int i=n-1; i>=0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int take = 0;
            for(int s=0; s<3 && i+s < n; s++) {
                take += piles[i+s];
                dp[i] = Math.max(dp[i], take - dp[i+s+1]);
            }
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }

}
