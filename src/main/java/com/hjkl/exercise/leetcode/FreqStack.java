package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, ArrayDeque<Integer>> map;
    private int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxFreq = Math.max(maxFreq, f);
        if (!map.containsKey(f)) map.put(f, new ArrayDeque<>());
        map.get(f).push(x);
    }

    public int pop() {
        int x = map.get(maxFreq).pop();
        freq.put(x, maxFreq-1);
        if (map.get(maxFreq).size() == 0) maxFreq--;
        return x;
    }
}
