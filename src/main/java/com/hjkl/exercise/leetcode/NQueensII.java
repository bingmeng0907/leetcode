package com.hjkl.exercise.leetcode;

public class NQueensII {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        // 主对角线
        boolean[] d1 = new boolean[2*n];
        // 副对角线
        boolean[] d2 = new boolean[2*n];
        return backtrack(0, col, d1, d2, n, 0);
    }

    private int backtrack(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n, int count) {
        if (row == n) {
            count++;
        } else {
            for(int i=0; i<n; i++) {
                if (cols[i] || d1[row-i+n] || d2[row+i]) continue;
                cols[i] = d1[row-i+n] = d2[row+i] = true;
                count = backtrack(row+1, cols, d1, d2, n, count);
                cols[i] = d1[row-i+n] = d2[row+i] = false;
            }
        }
        return count;
    }

}
