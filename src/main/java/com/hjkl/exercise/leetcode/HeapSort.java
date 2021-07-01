package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class HeapSort {

    public static void sort(int[] arr) {
        if(arr == null || arr.length <= 1) return;
        int begin = (arr.length>>1) - 1;
        for(int i=begin; i>=0; i--) {
            heapify(arr, i, arr.length-1);
        }
        for(int i=arr.length-1; i>0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i-1);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int l = (i<<1) + 1;
        if(l > len) return;
        int r = l + 1;
        int max = l;
        if(r <= len && arr[r] > arr[max]) max = r;
        if(arr[i] < arr[max]) {
            swap(arr, i, max);
            heapify(arr, max, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
         HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
