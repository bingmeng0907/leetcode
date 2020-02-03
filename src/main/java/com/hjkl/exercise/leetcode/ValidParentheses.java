package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;

public class ValidParentheses {
    public boolean isValid(String str) {
        if (str == null || str.length() <= 0) return true;
        if (str.length() % 2 == 1) return false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chs = str.toCharArray();
        for(int i=0; i<chs.length; i++) {
            if (chs[i] == '[' || chs[i] == '(' || chs[i] == '{') {
                stack.push(chs[i]);
            } else {
                if (stack.isEmpty()) return false;
                char tmp = stack.poll();
                switch (chs[i]) {
                    case ']':
                        if(tmp != '[') return false;
                        break;
                    case ')':
                        if(tmp != '(') return false;
                        break;
                    case '}':
                        if (tmp != '{') return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
