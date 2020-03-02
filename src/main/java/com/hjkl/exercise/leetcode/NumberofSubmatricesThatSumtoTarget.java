package com.hjkl.exercise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumtoTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++) {
            for(int j=1; j<n; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                Map<Integer, Integer> count = new HashMap<>();
                count.put(0, 1);
                int sum = 0;
                for(int k=0; k<m; k++) {
                    sum += matrix[k][j] - (i==0?0:matrix[k][i-1]);
                    res += count.getOrDefault(sum-target, 0);
                    count.put(sum, count.getOrDefault(sum, 0)+1);
                }
            }
        }
        return res;
    }
}
