package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        /*
            For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
            your output should be [1, 1, 4, 2, 1, 1, 0, 0].
         */

        // native algorithm
        /*
        int[] ret = new int[T.length];
        for(int i=0; i<T.length; i++) {
            int r = 0;
            for(int j=i+1; j<T.length; j++) {
                if (T[j] > T[i]) {
                    r = j-i;
                    break;
                }
            }
            ret[i] = r;
        }
        return ret;
        */
        // stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ret = new int[T.length];
        for(int i=0; i<T.length; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i-idx;
            }
            stack.push(i);
        }
        return ret;
    }
}
