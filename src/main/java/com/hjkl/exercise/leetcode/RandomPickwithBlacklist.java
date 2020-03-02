package com.hjkl.exercise.leetcode;

import java.util.*;

public class RandomPickwithBlacklist {
    private Map<Integer, Integer> map;
    private Random random;
    private int M;
    public RandomPickwithBlacklist(int N, int[] blacklist) {
        Set<Integer> set = new HashSet<>();
        for(int b : blacklist) {
            set.add(b);
        }
        map = new HashMap<>();
        random = new Random();
        M = N - set.size();
        for(int b : blacklist) {
            if (b < M) {
                while(set.contains(N-1)) {
                    N--;
                }
                map.put(b, N-1);
                set.remove(N-1);
                N--;
            }
        }
    }

    public int pick() {
        int p = random.nextInt(M);
        if (map.containsKey(p)) {
            return map.get(p);
        }
        return p;
    }
}
