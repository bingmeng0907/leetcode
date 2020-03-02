package com.hjkl.exercise.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer,Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity,0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
}
