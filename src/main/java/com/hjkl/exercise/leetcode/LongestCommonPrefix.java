package com.hjkl.exercise.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) return "";
        char[]  chs = strs[0].toCharArray();
        for(int i=0; i<chs.length; i++) {
            char ch = chs[i];
            for(int j=1; j<strs.length; j++) {
                char[] chtmp = strs[j].toCharArray();
                if (i >= chtmp.length || chtmp[i] != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        new LongestCommonPrefix().longestCommonPrefix(strs);
    }
}
