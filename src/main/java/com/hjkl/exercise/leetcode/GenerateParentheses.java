package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        backtrack(ret, "", 0, 0, n);
        return ret;
    }

    private void backtrack(List<String> ret, String s, int open, int close, int n) {
        if (s.length() == 2*n) {
            ret.add(s);
            return;
        }
        if (open < n) {
            backtrack(ret, s + "(", open+1, close, n);
        }
        if (close < open) {
            backtrack(ret, s + ")", open, close+1, n);
        }
    }
}
