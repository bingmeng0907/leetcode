package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 1) return res;
        int len = nums.length;
        int[] index = new int[len];
        int[] tmp = new int[len];
        int[] ans = new int[len];
        for(int i=0; i<len; i++) index[i] = i;
        mergeSort(nums, index, tmp, ans, 0, len-1);
        for(int i=0; i<len; i++) res.add(ans[i]);
        return res;
    }

    private void mergeSort(int[] nums, int[] index, int[] tmp, int[] ans, int l, int r) {
        if(l == r) return;
        int m = l + (r-l) / 2;
        mergeSort(nums, index, tmp, ans, l, m);
        mergeSort(nums, index, tmp, ans, m+1, r);
        if(nums[index[m]] <= nums[index[m+1]]) return;
        mergeAndCount(nums, index, tmp, ans, l, m, r);
    }

    private void mergeAndCount(int[] nums, int[] index, int[] tmp, int[] ans, int l, int m, int r) {
        for(int i = l; i<=r; i++) tmp[i] = index[i];
        int i = l, j = m + 1;
        for(int k=l; k<=r; k++) {
            if(i > m) {
                index[k] = tmp[j];
                j++;
            } else if (j > r) {
                index[k] = tmp[i];
                i++;
                ans[index[k]] += r - m;
            } else if( nums[tmp[i]] <= nums[tmp[j]]) {
                index[k] = tmp[i];
                i++;
                ans[index[k]] += j - m - 1;
            } else {
                index[k] = tmp[j];
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        List<Integer> res = new CountSmallerAfterSelf().countSmaller(nums);
        for(int i=0; i<res.size(); i++) System.out.println(res.get(i));
    }
}
