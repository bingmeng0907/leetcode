package com.hjkl.exercise.leetcode;

public class StoneGameV {
    public int stoneGameV(int[] piles) {
        int n = piles.length;
        int[][] cache = new int[n][n];
        int sum = 0;
        for(int s : piles) sum += s;
        return dfs(piles, 0, n-1, sum, cache);
    }

    private int dfs(int[] piles, int l, int r, int sum, int[][] cache) {
        if(cache[l][r] > 0) return cache[l][r];
        int lsum = 0;
        int max = 0;
        for(int i=l; i<r; i++) {
            lsum += piles[i];
            int rsum = sum - lsum;
            if(lsum > rsum) {
                int remain = dfs(piles, i+1, r, rsum, cache);
                max = Math.max(max, remain + rsum);
            } else if (lsum < rsum) {
                int remain = dfs(piles, l, i, lsum, cache);
                max = Math.max(max, remain+lsum);
            } else {
                int lremain = dfs(piles, l, i, lsum, cache);
                max = Math.max(max, lremain+lsum);
                int rremain = dfs(piles, i+1, r, rsum, cache);
                max = Math.max(max, rremain+rsum);
            }
        }
        cache[l][r] = max;
        return max;
    }
}
