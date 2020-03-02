package com.hjkl.exercise.leetcode;

public class MinimumInsertionStepstoMakeaStringPalindrome {
    public int minInsertions(String s) {
        String rs = new StringBuilder(s).reverse().toString();
        return s.length() - lcs(s,rs);
    }

    private int lcs(String s, String r) {
        if (s == null || r == null) return 0;
        int m = s.length(), n = r.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (s.charAt(i) == r.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
