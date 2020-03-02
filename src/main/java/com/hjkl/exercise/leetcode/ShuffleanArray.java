package com.hjkl.exercise.leetcode;

import java.util.*;

public class ShuffleanArray {
    private List<Integer>  list;
    private final Random random = new Random();
    public ShuffleanArray(int[] nums) {
        list = new ArrayList<>();
        for(int n : nums) {
            list.add(n);
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] ret = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = new int[list.size()];
        List<Integer> tmp = new ArrayList<>(list);
        for(int i=0; i<ret.length; i++) {
            int bound = tmp.size();
            ret[i] = tmp.remove(random.nextInt(bound));
        }
        return ret;
    }
}
