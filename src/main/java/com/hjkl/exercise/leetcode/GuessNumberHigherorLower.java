package com.hjkl.exercise.leetcode;

public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int l = 1, h = n;
        while(l<=n) {
            int m = l + (h-l)/2;
            int r = guess(m);
            if (r == 0) {
                return m;
            } else if (r == -1) {
                h = m -1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    private int guess(int m) {
        return 0;
    }
}
