package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumofSubsequenceWidths {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long sum = 0, c = 1, mod = (long)1e9+7;
        for(int i=0, n=A.length; i<n; i++, c=(c*2) % mod) {
            sum = (sum + A[i]*c - A[n-i-1]*c) % mod;
        }
        return (int)sum;
//        List<List<Integer>> subSeq = getSubSeq(A);
//        //System.out.println(subSeq.size());
//        int sum = 0;
//        for(List<Integer> list : subSeq) {
//            sum += (list.get(list.size()-1) - list.get(0));
//        }
//        return sum;
    }

    private List<List<Integer>> getSubSeq(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, ret, tmp, 0);
        return ret;
    }

    private void backtrack(int[] nums, List<List<Integer>> ret,
                           List<Integer> tmp, int idx) {
        if (!tmp.isEmpty()) {
            ret.add(new ArrayList<>(tmp));
        }
        for(int i=idx; i<nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, ret, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int sum = new SumofSubsequenceWidths().sumSubseqWidths(nums);
        System.out.println(sum);
    }
}
