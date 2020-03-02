package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortanArray {
    public List<Integer> sortArray(int[] nums) {
        int[] sort = mergeSort(nums, 0, nums.length-1);
//        System.out.println(Arrays.toString(sort));
        List<Integer> ret = new ArrayList<>();
        for(int i : sort) {
            ret.add(i);
        }
        return ret;
    }

    // bottom up
    private void mergeSort2(int[] nums) {
        for(int step=2; step<=nums.length; step *= 2) {

        }
    }

    // top down
    private int[] mergeSort(int[] nums, int s, int e) {
        if (s == e) return new int[]{nums[s]};
        int m = s + (e-s)/2;
        int[] left = mergeSort(nums, s, m);
        int[] right = mergeSort(nums, m+1, e);
        int[] newNum = new int[left.length + right.length];
        int i=0, j=0, idx=0;
        while(i<left.length && j<right.length) {
            if (left[i]<=right[j]) {
                newNum[idx] = left[i];
                i++;
            } else {
                newNum[idx] = right[j];
                j++;
            }
            idx++;
        }
        while(i<left.length) {
            newNum[idx++] = left[i++];
        }
        while(j<right.length) {
            newNum[idx++] = right[j++];
        }
        return newNum;
    }
}
