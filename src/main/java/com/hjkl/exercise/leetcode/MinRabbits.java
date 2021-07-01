package com.hjkl.exercise.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinRabbits {

    public int numRabbits(int[] ans) {
        if (ans == null || ans.length <= 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : ans) map.put(x, map.getOrDefault(x, 0) + 1);
        int ret = 0;
        for(int num : map.keySet()) {
            int freq = map.get(num);
            ret += (freq + num) / (num + 1) * (num + 1); // 先向上取整，然后计算
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ans = {0,0,1,1,1};
        System.out.println(new MinRabbits().numRabbits(ans));
    }

}
