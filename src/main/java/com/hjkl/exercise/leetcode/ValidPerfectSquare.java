package com.hjkl.exercise.leetcode;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int l = 1, h = num;
        while(l<=h) {
            long m = l + (h-l)/2;
            if (m*m == num) {
                return true;
            } else if (m*m > num) {
                h = (int)m - 1;
            } else {
                l = (int)m + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new ValidPerfectSquare().isPerfectSquare(5);
    }
}
