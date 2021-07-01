package com.hjkl.exercise.leetcode;

class StoneGame {

    class Node {
        int f;
        int s;

        Node(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Node[][] dp = new Node[n][n];
        // init dp table
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i == j) {
                    dp[i][j] = new Node(piles[i], 0);
                } else {
                    dp[i][j] = new Node(0, 0);
                }
            }
        }
        for(int i=n-2; i>=0; i--) {
            for(int j=i+1; j<n; j++) {
                // choose left piles
                int left = piles[i] + dp[i+1][j].s;
                int right = piles[j] + dp[i][j-1].s;
                if(left > right) {
                    dp[i][j].f = left;
                    dp[i][j].s = dp[i+1][j].f;
                 } else {
                    dp[i][j].f = right;
                    dp[i][j].s = dp[i][j-1].f;
                }
            }
        }
        return dp[0][n-1].f - dp[0][n-1].s > 0;
    }
}
