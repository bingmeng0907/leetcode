package com.hjkl.exercise.leetcode;

import java.util.*;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) return new double[0];
        double[] ret = new double[nums.length-k+1];
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.remove());
            } else {
                left.add(nums[i]);
                right.add(left.remove());
            }
            if (left.size() + right.size() == k) {
                double median = 0;
                if (left.size() == right.size()) {
                    median = (double) ((long)left.peek() + (long)right.peek()) / 2;
                } else {
                    median = left.peek();
                }
                int idx = i-k+1;
                ret[idx] = median;
                if (!left.remove(nums[idx])) {
                    right.remove(nums[idx]);
                }
            }
        }

        return ret;
    }
    private double getMedian(List<Integer> list, int k) {
        Collections.sort(list);
        return (list.get((k-1)/2) + list.get(k/2))/2.0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        PriorityQueue<Integer> left = new PriorityQueue<>();
        for(int n : nums) {
            left.add(n);
        }
        while(!left.isEmpty()) {
            System.out.println(left.remove());
        }
    }
}
