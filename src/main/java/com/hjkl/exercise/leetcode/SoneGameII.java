package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class SoneGameII {
    public int stoneGameII(int[] piles) {
        // compute the pre sum from back to front
        int[] presum = Arrays.copyOf(piles, piles.length);
        int n = piles.length;
        for (int i = n - 2; i >= 0; i--) {
            presum[i] = presum[i] + presum[i + 1];
        }
        int[][] cache = new int[n][n];
        return dp(presum, 1, 0, cache);
    }
    private int dp(int[] presum, int m, int idx, int[][] cache) {
        if (idx + 2 * m >= presum.length) {
            return presum[idx];
        }
        if (cache[idx][m] > 0) {
            return cache[idx][m];
        }
        int res = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int take = presum[idx] - presum[idx + i];
            res = Math.max(res, take + presum[idx + i] - dp(presum, Math.max(i, m), idx + i, cache));
        }
        cache[idx][m] = res;
        return res;
    }

    private int dfs(int[] presum, int m, int p, int[][] memo) {
        if (p + 2 * m >= presum.length) { // last player takes all
            return presum[p];
        }

        if (memo[p][m] > 0) return memo[p][m];
        int res = 0, take = 0;
        for (int i = 1; i <= 2 * m; i++) {
            // current take
            take = presum[p] - presum[p + i];
            // take max of current + what lefts from other player max take
            res = Math.max(res, take + presum[p + i] - dfs(presum, Math.max(i, m), p + i, memo));
        }
        memo[p][m] = res;
        return res;
    }
}
