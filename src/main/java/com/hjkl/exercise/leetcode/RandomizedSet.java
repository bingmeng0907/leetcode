package com.hjkl.exercise.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    private Map<Integer, Integer> valueMap;
    private Map<Integer, Integer> idxMap;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueMap = new HashMap<>();
        idxMap = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueMap.containsKey(val)) return false;
        valueMap.put(val, valueMap.size());
        idxMap.put(idxMap.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueMap.containsKey(val)) return false;
        int idx = valueMap.get(val);
        valueMap.remove(val);
        idxMap.remove(idx);
        Integer tail = idxMap.get(idxMap.size());
        if (tail != null) {
            valueMap.put(tail, idx);
            idxMap.put(idx, tail);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (valueMap.isEmpty()) return -1;
        Random random = new Random();
        int idx = random.nextInt(valueMap.size());
        return idxMap.get(idx);
    }
}
