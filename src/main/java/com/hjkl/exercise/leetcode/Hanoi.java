package com.hjkl.exercise.leetcode;

public class Hanoi {
    public void hanoi(int n, char A, char B, char C) {
        if(n == 1) {
            System.out.println("move " + A + " to " + C);
        } else {
            hanoi(n-1, A, C, B);
            System.out.println("move " + A + " to " + C);
            hanoi(n-1, B, A, C);
        }
    }
}
