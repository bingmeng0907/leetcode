package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=digits.length-1; i>=0; i--) {
            int x = digits[i];
            if (i == digits.length-1) {
                x += 1;
            }
            stack.push((carry+x)%10);
            carry = (carry+x) / 10;
        }
        if (carry == 1) stack.push(carry);
        int[] ret = new int[stack.size()];
        int i= 0;
        while(!stack.isEmpty()) {
            ret[i++] = stack.pop();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,9};
        new PlusOne().plusOne(digits);
    }
}
