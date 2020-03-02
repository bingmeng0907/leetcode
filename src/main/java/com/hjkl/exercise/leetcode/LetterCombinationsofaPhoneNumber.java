package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits == null || digits.length() <= 0) return queue;
        String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.offer("");
        for(int i=0; i<digits.length(); i++) {
            char ch = digits.charAt(i);
            String letters = arr[ch-'0'];
            while(queue.peek().length() == i) {
                String s = queue.poll();
                for(char c : letters.toCharArray()) {
                    queue.offer(s + c);
                }
            }
        }
        return queue;
    }

    private void backtrack(List<String> ret, String digits, StringBuilder sb, int idx, String[] arr) {
        if (idx == digits.length()) {
            ret.add(sb.toString());
            return;
        }
        String letters = arr[digits.charAt(idx) - '0'];
        for (char ch : letters.toCharArray()) {
            sb.append(ch);
            backtrack(ret, digits, sb, idx + 1, arr);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
