package com.hjkl.exercise.leetcode;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        Map<Integer, List<Integer>> sameValueOfIndex = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++) {
            int v = arr[i];
            if (sameValueOfIndex.containsKey(v)) {
                sameValueOfIndex.get(v).add(i);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                sameValueOfIndex.put(v, tmp);
            }
        }
        boolean[] visit = new boolean[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visit[0] = true;
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int idx = queue.poll();
                if (idx == n-1) return step;
                List<Integer> next = sameValueOfIndex.get(arr[idx]);
                next.add(idx-1);
                next.add(idx+1);
                for(int k : next) {
                    if (k >= 0 && k < n && !visit[k]) {
                        visit[k] = true;
                        queue.add(k);
                    }
                }
                next.clear();
            }
            step++;
        }
        return step;
    }
}
