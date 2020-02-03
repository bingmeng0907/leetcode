package com.hjkl.exercise.leetcode;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        int[] hash = new int[26];
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        for(char ch : sch) {
           hash[ch-'a']++;
        }
        for(char ch : tch) {
            hash[ch-'a']--;
        }
        for(int i : hash) {
            if (i != 0) return false;
        }
        return true;
    }
}
