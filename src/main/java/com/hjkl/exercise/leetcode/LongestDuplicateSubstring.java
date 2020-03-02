package com.hjkl.exercise.leetcode;

public class LongestDuplicateSubstring {
    public String longestDupSubstring(String s) {
        if (s == null || s.length() <= 0) return "";
//        int[] hash = new int[26];
//        int left=0, right=0,len= Integer.MIN_VALUE;
//        for(right=0; right<s.length(); right++) {
//            hash[s.charAt(right)-'a']++;
//
//        }

        int max = Integer.MIN_VALUE, l=0,r=0;
        int start = 0, end = -1;
        for(int i=0; i<s.length(); i++) {
           char c = s.charAt(i);
           for(l=i-1; l>=0 && s.charAt(l) != c; l--);
           if (l != -1) {
               if (i-l+1 > max) {
                   max = i-l+1;
                   start = l;
                   end = i;
               }
           }
           for(r=i+1; r<s.length() && s.charAt(r) != c; r++);
           if (r != s.length()) {
               if (r-i+1 > max) {
                   max = r-i+1;
                   start = i;
                   end = r;
               }
           }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        String s = "banana";
//        s = "abcd";
        String r = new LongestDuplicateSubstring().longestDupSubstring(s);
        System.out.println(r);
    }
}
