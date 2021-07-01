package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseKDigit {
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new ArrayDeque<>();
        for(int i=0; i<num.length(); i++) {
            char c = num.charAt(i);
            while (stk.size() > 0 && k > 0 && stk.peekLast() > c) {
                stk.pollLast();
                k--;
            }
            stk.offerLast(c);
        }
        while(k-- > 0 && !stk.isEmpty()) stk.pollLast();
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
            char c = stk.pollFirst();
            if(sb.length() == 0 && c == '0') {
                continue;
            }
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        num = "10200";
        k = 1;

        num = "1234567890";
        k = 9;
        System.out.println(new ReverseKDigit().removeKdigits(num, k));
    }

}
