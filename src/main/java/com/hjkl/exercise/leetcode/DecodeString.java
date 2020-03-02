package com.hjkl.exercise.leetcode;

import java.nio.charset.Charset;
import java.util.ArrayDeque;

public class DecodeString {
    public String decodeString(String s) {
        /*
            s = "3[a]2[bc]", return "aaabcbc".
            s = "3[a2[c]]", return "accaccacc".
            s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
         */
        if (s == null || s.length() <= 0) return "";
        ArrayDeque<Integer> cntStack = new ArrayDeque<>();
        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for(char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k*10 + ch-'0';
            } else if (ch == '[') {
                cntStack.push(k);
                k = 0;
                stack.push(cur);
                cur = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = stack.pop();
                for(int i= cntStack.pop(); i>0; i--) {
                    cur.append(tmp);
                }
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }
}
