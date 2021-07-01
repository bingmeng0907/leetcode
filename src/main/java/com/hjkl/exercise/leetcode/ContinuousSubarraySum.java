package com.hjkl.exercise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length <= 0) return true;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int presum = 0;
        for(int i=0; i<nums.length; i++){
           presum += nums[i];
           int key = presum % k;
           if(map.containsKey(key)) {
               if(i - map.get(key) >= 2) return true;
           }
           map.put(key, Math.min(map.getOrDefault(key, i), i));
        }
        return false;
    }
}
