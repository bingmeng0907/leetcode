package com.hjkl.exercise.leetcode;

public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            for(int k=1; k*k<=i; k++) {
                if(!dp[i-k*k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        boolean[] bs = new boolean[2];
        System.out.println(bs[0]);
    }
}
