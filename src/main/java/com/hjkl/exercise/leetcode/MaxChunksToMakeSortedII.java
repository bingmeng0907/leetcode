package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length <= 0) return 0;
        int[] sortArr = new int[arr.length];
        System.arraycopy(arr, 0, sortArr, 0, arr.length);
        Arrays.sort(sortArr);
        int ret = 0;
        int s1 = 0;
        int s2 = 0;
        for(int i=0; i<arr.length; i++) {
            s1 += arr[i];
            s2 += sortArr[i];
            if (s1 == s2) ret++;
        }
        return ret;
    }
}
