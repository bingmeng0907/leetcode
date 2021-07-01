package com.hjkl.exercise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraysDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length <= 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int presum = 0;
        int count = 0;
        for(int x : nums) {
            presum += x;
            int key = Math.abs(presum % k);
            if(map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 9};
        SubArraysDivByK sdb = new SubArraysDivByK();
        System.out.println(sdb.subarraysDivByK(nums, 2));
    }
}
