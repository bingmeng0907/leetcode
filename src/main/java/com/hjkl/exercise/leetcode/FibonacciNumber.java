package com.hjkl.exercise.leetcode;

public class FibonacciNumber {
    public int fib(int N) {
        if (N < 2) return N;
        int first = 0;
        int second = 1;
        for(int i=2; i<=N; i++) {
            int ret = first+second;
            first = second;
            second = ret;
        }
        return second;
    }
}
