package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        int[][] cache = new int[numRows+1][numRows+1];
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=1; j<=i; j++) {
                int v = cal(i,j, cache);
                list.add(v);
            }
            ret.add(list);
        }
        return ret;
    }
    private int cal(int i, int j, int[][] cache) {
        if (j == 1 || i == j) return 1;
        if (cache[i][j] != 0) return cache[i][j];
        int v = cal(i-1, j-1, cache) + cal(i-1, j, cache);
        cache[i][j] = v;
        return v;
    }
}
