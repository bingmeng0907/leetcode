package com.hjkl.exercise.leetcode;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() <= 0) return 0;
        int[] hash = new int[26];
        int start=0, end=0,op=0,len=0;
        while(end<s.length()) {
            char ec = s.charAt(end);
            if (hash[ec-'A'] == 0) op++; // new char
            hash[ec-'A']++;
            end++;
            if (op == k+1) len = Math.max(len, end-start);
            while(op > k+1) {
                char sc = s.charAt(start);
                if (hash[sc-'A'] == 1) op--; // del new char
                hash[sc-'A']--;
                start++;
            }
            //len = Math.max(len, end-start);
        }
        System.out.println(len);
        return len;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        new LongestRepeatingCharacterReplacement().characterReplacement(s, 2);
        s = "AABABBA";
        new LongestRepeatingCharacterReplacement().characterReplacement(s, 1);

    }
}
