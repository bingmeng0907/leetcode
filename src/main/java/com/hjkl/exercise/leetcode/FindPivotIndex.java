package com.hjkl.exercise.leetcode;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for(int n : nums) sum += n;
        for(int i=0; i<nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    /*
    public int pivotIndex(int[] nums) {
        int ret = -1;
        if (nums == null || nums.length <= 0) return ret;
        int[] pre = new int[nums.length];
        pre[0] = 0;
        for(int i=1; i<nums.length; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        int[] suf = new int[nums.length];
        suf[suf.length-1] = 0;
        for(int j=suf.length-2; j >= 0; j--) {
            suf[j] = suf[j+1] + nums[j+1];
        }
        for(int k=0; k<nums.length; k++) {
            if (pre[k] == suf[k]) return k;
        }
        return ret;
    }

    public int pivotIndex(int[] nums) {
        int ret = -1;
        for(int i=0; i<nums.length; i++) {
           if (valid(nums, i)) {
               ret = i;
               break;
           }
        }
        return ret;
    }

    private boolean valid(int[] nums, int idx) {
        int pre = 0, suf = 0;
        for(int i=0; i<idx; i++) {
            pre += nums[i];
        }
        for(int i=idx+1; i<nums.length; i++) {
            suf += nums[i];
        }
        return pre == suf;
    }
    */
}
