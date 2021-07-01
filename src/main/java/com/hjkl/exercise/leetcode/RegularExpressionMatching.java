package com.hjkl.exercise.leetcode;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;
        for(int i=m; i>=0; i--) {
            for(int j=n; j>=0; j--) {
                if(i == m && j == n) continue;
                boolean firstMatch = (i < m && j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                if( j+1 < n && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
