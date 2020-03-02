package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        int idx = 0;
        int dis = Math.abs(arr[0]-x);
        for(int i=1; i<arr.length; i++) {
            int tmp = Math.abs(arr[i]-x);
            if (tmp < dis) {
                idx = i;
                dis = tmp;
            }
        }
        int count = 1;
        int i = idx - 1;
        int j = idx + 1;
        while(count < k){
            if(i < 0) j++;
            else if(j >= arr.length) i--;
            else if(Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) i--;
            else j++;
            count++;
        }

        for(int m = i + 1; m <= j - 1; m++) ret.add(arr[m]);
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        new FindKClosestElements().findClosestElements(arr, 4, 3);
    }
}
