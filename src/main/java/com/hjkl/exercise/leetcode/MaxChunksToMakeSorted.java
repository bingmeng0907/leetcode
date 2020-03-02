package com.hjkl.exercise.leetcode;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length <= 0) return 0;
        int ret = 0, max = 0;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(arr[i], max);
            if (i == max) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        //int[] arr = {4,3,2,1,0};
        //int[] arr = {2, 0, 1};
        //int[] arr = {2, 0, 1, 3};
        int[] arr = {1,0,2,3,4};
        new MaxChunksToMakeSorted().maxChunksToSorted(arr);
    }
}
