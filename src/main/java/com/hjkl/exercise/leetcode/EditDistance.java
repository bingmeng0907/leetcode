package com.hjkl.exercise.leetcode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) dp[i][0] = i;
        for(int j=0; j<=n; j++) dp[0][j] = j;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j+1] + 1;
                    int delete = dp[i+1][j] + 1;
                    dp[i+1][j+1] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[m][n];
    }
}
