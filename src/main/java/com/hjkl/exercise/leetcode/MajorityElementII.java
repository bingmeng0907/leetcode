package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length <= 0) return ret;
        int cand1 = -1, cand2 = -1;
        int count1 = 0, count2 = 0;
        for(int x : nums) {
            if (x == cand1) {
                count1++;
            } else if (x == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = x;
                count1++;
            } else if (count2 == 0) {
                cand2 = x;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int x : nums) {
            if (x == cand1) {
                count1++;
            } else if (x == cand2) {
                count2++;
            }
        }
        if (count1 > nums.length/3) ret.add(cand1);
        if (count2 > nums.length/3) ret.add(cand2);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {8,8,7,7,7};
        new MajorityElementII().majorityElement(nums);
    }
}
