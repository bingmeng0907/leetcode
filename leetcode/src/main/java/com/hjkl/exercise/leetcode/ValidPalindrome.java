package com.hjkl.exercise.leetcode;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 0) return true;
//        s = s.toLowerCase().replaceAll("[^a-b|^0-9]", "");
//        int i=0, j=s.length()-1;
//        while(i<=j) {
//            if (s.charAt(i++) != s.charAt(j--)) return false;
//        }
//        return true;
        s = s.toLowerCase();
        int l=0, r=s.length()-1;
        while(l<=r) {
            if (!((s.charAt(l) >= '0' && s.charAt(l) <= '9') ||
                (s.charAt(l) >= 'a' && s.charAt(l) <= 'z'))) {
                l++;
                continue;
            }
            if (!((s.charAt(r) >= '0' && s.charAt(r) <= '9') ||
                    (s.charAt(r) >= 'a' && s.charAt(r) <= 'z'))) {
                r--;
                continue;
            }
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
