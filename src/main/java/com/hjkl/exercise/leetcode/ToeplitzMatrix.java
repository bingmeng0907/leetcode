package com.hjkl.exercise.leetcode;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null) return true;
        int row = matrix.length;
        int cln = matrix[0].length;
        for(int i=0; i<row-1; i++) {
            if (!valid(matrix,i, i+1)) {
                return false;
            }
        }
        return true;
    }
    private boolean valid(int[][] matrix, int cur, int next) {
        /*
          [1,2,3,4],
          [5,1,2,3],
          [9,5,1,2]
        */
        for(int i=0; i<matrix[0].length-1; i++) {
            if (matrix[cur][i] != matrix[next][i+1]) return false;
        }
        return true;
    }
}
