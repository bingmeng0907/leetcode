package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class CountReversePair {
    public int countReversePair(int[] arr) {
        if(arr == null || arr.length <= 1) return 0;
        return mergeSort(arr, 0, arr.length-1);
    }

    private int mergeSort(int[] arr, int l, int r) {
        if(l == r) return 0;
        int m = l + (r-l)/2;
        int left = mergeSort(arr, l, m);
        int right = mergeSort(arr, m+1, r);
        return left + right + countAndMerge(arr, l, m, r);
    }

    private int countAndMerge(int[] arr, int l, int m, int r) {
        int count = 0;
        for(int i=l, j=m+1; i<=m;) {
            if(i > m) {
                j++;
            } else if (j > r) {
                i++;
            } else if (arr[i] <= arr[j]) {
                i++;
            } else {
                count += (m - i + 1);
                j++;
            }
        }
        Arrays.sort(arr, l, r+1);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {8,5,4,2,1};
        System.out.println(new CountReversePair().countReversePair(arr));
        System.out.println(Arrays.toString(arr));
    }
}
