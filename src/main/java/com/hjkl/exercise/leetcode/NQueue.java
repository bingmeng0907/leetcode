package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueue {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder("");
            for(int j=0; j<n; j++) {
                sb.append(".");
            }
            tmp.add(sb.toString());
        }
        backtrack(res, 0, n, tmp);
        return res;
    }

    private void backtrack(List<List<String>> res, int r, int n, List<String> tmp) {
        if(r == n) {
            res.add(new ArrayList<>(tmp));
        } else {
            for(int i=0; i<n; i++) {
                if(!isValid(tmp, i, r, n)) continue;
                StringBuilder sb = new StringBuilder(tmp.get(r));
                sb.setCharAt(i, 'Q');
                tmp.set(r, sb.toString());
                backtrack(res, r+1, n, tmp);
                sb.setCharAt(i, '.');
                tmp.set(r, sb.toString());
            }
        }
    }

    private boolean isValid(List<String> tmp, int c, int r, int n) {
        // check column
        for(int i=0; i<r; i++) {
            if(tmp.get(i).charAt(c) == 'Q') return false;
        }
        // check left-up
        for(int i=r-1,j=c-1; i>=0 && j>=0; i--,j--) {
            if(tmp.get(i).charAt(j) == 'Q') return false;
        }
        // check right-up
        for(int i=r-1,j=c+1; i>=0 && j<n; i--,j++) {
            if(tmp.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
}
