package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PerfectSquares {
    public int numSquares(int n) {
        // dp
        /*
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            int j=1;
            while(i-j*j>=0) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
        */
        // queue
        Set<Integer> visit = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visit.add(0);
        int cnt = 0;
        while(!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int u = queue.poll();
                for(int j=1; j*j<=n; j++) {
                    int v = u + j*j;
                    if (v == n) {
                        return cnt;
                    } else if (v > n) {
                        break;
                    } else {
                        if (!visit.contains(v)) {
                            queue.offer(v);
                            visit.add(v);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
