package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<String> ret = getAllPermutation(n);
        for(String str : ret) {
            System.out.println(str);
        }
        return null;
    }
    private List<String> getAllPermutation(int n) {
        List<String> ret = new ArrayList<>();
        backtrack(n, ret, new StringBuilder());
        return ret;
    }
    private void backtrack(int n, List<String> ret, StringBuilder sb) {
        if (sb.length() == n) {
            ret.add(sb.toString());
        } else {
            for(int i=1; i<=n; i++) {
                if (sb.indexOf(i+"") >= 0) continue;
                sb.append(i+"");
                backtrack(n, ret, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        new PermutationSequence().getPermutation(3, 3);
    }
}
