package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret,1, n, k, new ArrayList<Integer>());
        return ret;
    }

    private void backtrack(List<List<Integer>> ret,int s, int n, int k, ArrayList<Integer> tmp) {
        if (tmp.size() == k) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=s;i<=n; i++) {
            tmp.add(i);
            backtrack(ret, i+1, n, k, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        new Combinations().combine(4,2);
    }
}
