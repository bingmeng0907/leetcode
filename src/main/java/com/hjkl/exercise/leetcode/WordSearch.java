package com.hjkl.exercise.leetcode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() <= 0) return true;
        if (board == null || board.length*board[0].length < word.length()) return false;
        int row = board.length, cln = board[0].length;
        boolean[][] visit = new boolean[row][cln];
        for(int i=0; i<row; i++) {
            for(int j=0; j<cln; j++) {
                if (dfs(board,i,j,visit,word,0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, boolean[][] visit, String word, int idx){
        if (idx == word.length()) return true;
        if (i<0 || i>=board.length || j<0 || j>= board[0].length || visit[i][j] == true
                || board[i][j] != word.charAt(idx)) return false;
        visit[i][j] = true;
        boolean exist = dfs(board, i-1, j, visit, word, idx+1)
                || dfs(board, i+1, j, visit, word, idx+1)
                || dfs(board, i, j-1, visit, word, idx+1)
                || dfs(board, i, j+1, visit, word, idx+1);
        visit[i][j] = false;
        return exist;
    }
}
