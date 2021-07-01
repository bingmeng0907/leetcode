package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class RadixSort {

    private void radisSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int max = nums[0];
        for(int n : nums) max = Math.max(max, n);
        int l = nums.length;
        for(int i=1; max/i>0; i *= 10) {
            int[][] bucket = new int[l][10];
            for(int j=0; j<l; j++) {
                int d = (nums[j]/i) % 10;
                bucket[j][d] = nums[j];
            }
            int idx = 0;
            for(int k=0; k<10; k++) {
                for(int v=0; v<l; v++) {
                    if(bucket[v][k] != 0) nums[idx++] = bucket[v][k];
                }
            }
        }
    }


    public String largestNumber(int[] nums) {
        if(nums == null || nums.length <= 0) return "";
        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++) arr[i] = nums[i]+"";
        Arrays.sort(arr, (s1,s2) -> (int)(Long.parseLong(s2+s1) - Long.parseLong(s1+s2)));
        System.out.println(Arrays.toString(arr));
        return "";
    }

    public static void main(String[] args) {
        int[] nums = {9,3,5,1,2,10,7,22,333};
        new RadixSort().radisSort(nums);
        System.out.println(Arrays.toString(nums));
    }



}
