package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret,nums,new ArrayList<Integer>());
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, int[] nums, ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if (!tmp.contains(nums[i])) {
                tmp.add(nums[i]);
                backtrack(ret, nums, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
