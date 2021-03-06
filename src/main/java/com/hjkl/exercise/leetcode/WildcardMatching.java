package com.hjkl.exercise.leetcode;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int i=0, j=0, iStar = -1, jStar = -1, m = s.length(), n = p.length();
        while(i<m) {
            if (j<n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j<n && p.charAt(j) == '*') {
                iStar = i;
                jStar = j;
                j++;
            } else if (iStar >= 0) {
                iStar++;
                i = iStar;
                j = jStar + 1;
            } else {
                return false;
            }
        }
        while(j<n && p.charAt(j) == '*') j++;
        return j == p.length();
    }

    public static void main(String[] args) {
        String s= "aa", p = "a";
        s = "aa";p = "*";
        s = "cb"; p = "?a";
        s = "adceb";
        p = "*a*b";
        s = "acdscd";
        p = "*cd";
        new WildcardMatching().isMatch(s, p);
    }
}
