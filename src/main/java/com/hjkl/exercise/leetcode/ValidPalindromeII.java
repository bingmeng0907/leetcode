package com.hjkl.exercise.leetcode;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 0) return true;
        int i=0, j=s.length()-1;
        while(i<=j) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i+1, j) || validPalindrome(s, i, j-1);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    private boolean validPalindrome(String s, int l, int r) {
        while(l<=r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
