package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;

public class MinStack {
    ArrayDeque<Integer> s1;
    ArrayDeque<Integer> s2;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        s1.push(x);
        min = Math.min(min, x);
        s2.push(min);
    }

    public void pop() {
        s1.pop();
        s2.pop();
        min = (s2.isEmpty() ? Integer.MAX_VALUE : s2.peek());
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
