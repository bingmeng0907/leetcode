package com.hjkl.exercise.leetcode;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] ret = new int[m*n];
        int row = 0, cln = 0, d = 1;
        for(int i=0; i<ret.length; i++) {
            ret[i] = matrix[row][cln];
            row -= d;
            cln += d;
            if (row >= m) { row = m - 1;cln += 2;d = -d;}
            if (cln >= n) { cln = n -1; row += 2;d = -d;}
            if (row < 0) {row = 0;d = -d;}
            if (cln < 0) {cln = 0;d = -d;}
        }
        return ret;
    }
}
