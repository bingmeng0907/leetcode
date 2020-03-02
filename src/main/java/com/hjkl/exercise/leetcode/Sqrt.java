package com.hjkl.exercise.leetcode;

public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1, h = x;
        while(l <= h) {
            int m = l + (h-l)/2;
            int sqrt = x / m;
            if (sqrt == m) {
                return m;
            } else if (sqrt > m) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return h;
    }
}
