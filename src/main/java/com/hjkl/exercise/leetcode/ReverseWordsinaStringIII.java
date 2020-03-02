package com.hjkl.exercise.leetcode;

public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 0) return s;
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length;) {
            int j = i;
            while(j< chs.length && chs[j] != ' ') {
                j++;
            }
            swap(chs, i, j-1);
            i = j+1;
        }
        return new String(chs);
    }

    private void swap(char[] chs, int i, int j) {
        while(i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        new ReverseWordsinaStringIII().reverseWords(s);
    }
}
