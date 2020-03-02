package com.hjkl.exercise.leetcode;

public class SudoKuSolver {

    private boolean solver(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if (board[i][j] != '.') continue;
                for(char ch='1'; ch<='9'; ch++) {
                    if (valid(i, j, board, ch)) {
                        board[i][j] = ch;
                        if (solver( board)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean valid(int row, int col, char[][] board, char ch) {
        int blockRow = (row/3)*3, blockCol = (col/3)*3;
        for(int i=0; i<9; i++) {
            if (board[i][col] == ch || board[row][i] == ch ||
                    board[blockRow + i/3][blockCol + i%3] == ch) return false;
        }
        return true;
    }
}
