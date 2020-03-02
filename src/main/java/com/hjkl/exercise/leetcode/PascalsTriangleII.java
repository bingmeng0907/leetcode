package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow2(int rowIndex) {
        rowIndex = rowIndex + 1;
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex <= 0) return result;

        for (int i = 0; i < rowIndex; i++) {
            result.add(0, 1);
            //last index is reserved for 1, which we insert in the first loop
            for (int j = 1; j < result.size() - 1; j++) {
                //we are supposed to find j -1 and j, but we have added 0 in front so index is rightshfited
                result.set(j, result.get(j) + result.get(j + 1));
            }
        }

        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[][] cache = new int[rowIndex + 1][rowIndex + 1];
        for (int cln = 1; cln <= rowIndex + 1; cln++) {
            int v = cal(rowIndex + 1, cln, cache);
            list.add(v);
        }
        return list;
    }

    private int cal(int i, int j, int[][] cache) {
        if (j == 1 || i == j) return 1;
        if (cache[i][j] != 0) return cache[i][j];
        int v = cal(i - 1, j - 1, cache) + cal(i - 1, j, cache);
        cache[i][j] = v;
        return v;
    }

    public static void main(String[] args) {
        new PascalsTriangleII().getRow2(4);
    }
}
