package com.hjkl.exercise.leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n <= 1) return n;
        int l=1, h=n;
        while(l<h) {
            int m = l + (h-l)/2;
            boolean bool = isBadVersion(m);
            if (bool) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    boolean isBadVersion(int version){return true;}
}
