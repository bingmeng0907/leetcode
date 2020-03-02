package com.hjkl.exercise.leetcode;

import java.util.*;

public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length-1] - nums[0];
        while(low < high) {
            int mid = low + (high-low)/2;
            int pairs = countPairs(nums, mid);
            if (pairs < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countPairs(int[] nums, int mid) {
        int pairs = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length && nums[j]-nums[i]<=mid;j++) {
                pairs++;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        new FindKthSmallestPairDistance().smallestDistancePair(nums, 2);
    }
}
