package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums1) set.add(n);
        Set<Integer> s2 = new HashSet<>();
        for(int n : nums2) {
            if (set.contains(n)) {
                s2.add(n);
            }
        }
        int[] r = new int[s2.size()];
        int i = 0;
        for(int s : s2) {
            r[i++] = s;
        }
        return r;
    }
}
