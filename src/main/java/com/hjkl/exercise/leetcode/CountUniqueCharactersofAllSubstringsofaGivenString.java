package com.hjkl.exercise.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class CountUniqueCharactersofAllSubstringsofaGivenString {
    public int uniqueLetterString(String s) {
        if (s == null || s.length() <= 0) return 0;
//        int n = s.length(), l = 0, r = 0;
//        long ret = 0;
//        for(int i=0; i<n; i++) {
//            for(l=i-1; l>=0 && s.charAt(l) != s.charAt(i); l--);
//            for(r=i+1; r<n && s.charAt(r) != s.charAt(i); r++);
//            ret += (i-l)*(r-i);
//        }
//        int mod = (int)Math.pow(10,9)+7;
//        return (int)(ret % mod);
        int[][] idx = new int[26][2];
        for(int i=0; i<idx.length; i++) {
            Arrays.fill(idx[i], -1);
        }
        long ret = 0;
        for(int i=0; i<s.length();i++) {
            int c = s.charAt(i) - 'A';
            ret += ((i-idx[c][1]) * (idx[c][1]-idx[c][0]));
            idx[c][1] = i;
        }
        int n = s.length();
        for(int c = 0; c<26; c++) {
            ret += ((n-idx[c][1]) * (idx[c][1]-idx[c][0]));
        }
        int mod = (int)Math.pow(10,9)+7;
        return (int)(ret % mod);
    }
}
