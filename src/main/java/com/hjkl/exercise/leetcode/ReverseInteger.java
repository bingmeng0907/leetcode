package com.hjkl.exercise.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;
        int sign = 1;
        if (x < 0) sign = -1;
        x = Math.abs(x);
        int r = 0;
        while (x > 0) {
            if (sign > 0) {
                if (r > 214748364 || (r * 10 == 2147483640 && x % 10 > 7)) return 0;
            } else {
                if (r > 214748364 || (r * 10 == 2147483640 && x % 10 > 8)) return 0;
            }
            r = r * 10 + x % 10;
            x = x / 10;
        }
        return r * sign;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(2147483647));
    }
}
