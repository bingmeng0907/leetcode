package com.hjkl.exercise.leetcode;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visit = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], newColor, visit);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int oldColor, int newColor, boolean[][] visit) {
        if (i<0 || i>=image.length || j<0 || j>=image[0].length || visit[i][j]) return;
        visit[i][j] = true;
        if (oldColor == image[i][j]) {
            image[i][j] = newColor;
            dfs(image, i+1, j, oldColor, newColor, visit);
            dfs(image,i-1, j, oldColor, newColor, visit);
            dfs(image, i, j+1, oldColor, newColor, visit);
            dfs(image, i, j-1, oldColor, newColor, visit);
        }
    }
}
