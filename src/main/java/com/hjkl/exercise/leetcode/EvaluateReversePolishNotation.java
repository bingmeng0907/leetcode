package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0) return 0;
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int a1 = Integer.valueOf(stack.pop());
                int a2 = Integer.valueOf(stack.pop());
                switch (s) {
                    case "+":
                        stack.push(String.valueOf(a2+a1));
                        break;
                    case "-":
                        stack.push(String.valueOf(a2-a1));
                        break;
                    case "*":
                        stack.push(String.valueOf(a2*a1));
                        break;
                    case "/":
                        stack.push(String.valueOf(a2/a1));
                        break;
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        new EvaluateReversePolishNotation().evalRPN(tokens);
    }
}
