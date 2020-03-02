package com.hjkl.exercise.leetcode;

public class MaximumSumof3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = {-1,-1, -1};
        if (nums == null || nums.length <= 0) return ans;
        int[] sumWindows = new int[nums.length-k+1];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(i >= k) sum -= nums[i-k];
            if (i >= k-1) sumWindows[i-k+1] = sum;
        }
        int[] left = new int[sumWindows.length];
        int best = 0;
        for(int i=0; i<left.length; i++) {
            if (sumWindows[i] > sumWindows[best]) {
                best = i;
            }
            left[i] = best;
        }
        int[] right = new int[sumWindows.length];
        best = right.length-1;
        for(int i=right.length-1; i>=0; i--) {
            if (sumWindows[i] >= sumWindows[best]) {
                best = i;
            }
            right[i] = best;
        }
        for(int j=k; j<sumWindows.length-k; j++) {
            int l = left[j-k];
            int r = right[j+k];
            if (ans[0] == -1 ||
                    (sumWindows[l]+sumWindows[j]+sumWindows[r])
                            > (sumWindows[ans[0]]+sumWindows[ans[1]]+sumWindows[ans[2]])) {
                ans[0] = l;
                ans[1] = j;
                ans[2] = r;
            }
        }
        return ans;
    }

}
