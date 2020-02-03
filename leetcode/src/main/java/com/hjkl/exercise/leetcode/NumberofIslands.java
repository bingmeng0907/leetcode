package com.hjkl.exercise.leetcode;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) return 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int ret = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if (bfs(grid, visit, i, j)) {
                    ret++;
                }
            }
        }
        return ret;
    }
    private boolean bfs(char[][] grid, boolean[][] visit, int i, int j) {
        if (i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1
                || grid[i][j] == '0' || visit[i][j]) return false;
        visit[i][j] = true;
        bfs(grid, visit, i-1, j);
        bfs(grid, visit, i+1, j);
        bfs(grid, visit, i, j-1);
        bfs(grid, visit, i, j+1);
        return true;
    }
}
