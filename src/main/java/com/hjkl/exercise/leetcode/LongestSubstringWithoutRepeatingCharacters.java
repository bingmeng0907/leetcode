package com.hjkl.exercise.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int[] hash = new int[256];
        int start = 0, end = 0, len = 0, count = 0;
        while(end < s.length()) {
            char ec = s.charAt(end);
            if (hash[ec] > 0) { // repeat char
                count++;
            }
            hash[ec]++;
            end++;
            while(count > 0) {
                char sc = s.charAt(start);
                if (hash[sc] > 1) { // remove repeat char
                    count--;
                }
                hash[sc]--;
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }
}
