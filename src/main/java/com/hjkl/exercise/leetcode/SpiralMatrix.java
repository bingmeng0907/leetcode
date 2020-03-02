package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null) return ret;
        int m = matrix.length;
        if (m <= 0) return ret;
        int n = matrix[0].length;
        if (n <= 0) return ret;
        help(matrix, 0, m-1, 0, n-1, ret);
        return ret;
    }
    private void help(int[][] matrix, int rows, int rowe, int cols, int cole, List<Integer> ret) {
        if (rows > rowe) return;
        if (cols > cole) return;
        if (rows == rowe) {
            for(int i=cols; i<=cole; i++) {
                ret.add(matrix[rows][i]);
            }
            return;
        }
        if (cols==cole) {
            for(int i=rows; i<=rowe; i++) {
                ret.add(matrix[i][cols]);
            }
            return;
        }
        for(int i=cols; i<=cole; i++) {
            ret.add(matrix[rows][i]);
        }
        for(int i=rows+1; i<=rowe; i++) {
            ret.add(matrix[i][cole]);
        }
        for(int i=cole-1; i>=cols; i--) {
            ret.add(matrix[rowe][i]);
        }
        for(int i=rowe-1; i>=rows+1; i--) {
            ret.add(matrix[i][cols]);
        }
        help(matrix, rows+1, rowe-1, cols+1, cole-1, ret);
    }
}
