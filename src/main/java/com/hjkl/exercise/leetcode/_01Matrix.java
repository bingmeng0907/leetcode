package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _01Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null) return null;
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    visit[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] loc = queue.poll();
                int i=loc[0],j=loc[1];
                if(i-1>=0 && !visit[i-1][j]) {
                    matrix[i-1][j] = matrix[i][j]+1;
                    visit[i-1][j] = true;
                    queue.offer(new int[]{i-1,j});
                }
                if(i+1<matrix.length && !visit[i+1][j]) {
                    matrix[i+1][j] = matrix[i][j]+1;
                    visit[i+1][j] = true;
                    queue.offer(new int[]{i+1,j});
                }
                if(j-1>=0 && !visit[i][j-1]) {
                    matrix[i][j-1] = matrix[i][j]+1;
                    visit[i][j-1] = true;
                    queue.offer(new int[]{i,j-1});
                }
                if(j+1<matrix[0].length && !visit[i][j+1]) {
                    matrix[i][j+1] = matrix[i][j]+1;
                    visit[i][j+1] = true;
                    queue.offer(new int[]{i,j+1});
                }
            }
        }
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        return matrix;
    }
    /*
    [[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
     */

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        new _01Matrix().updateMatrix(matrix);
    }
}
