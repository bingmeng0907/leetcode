package com.hjkl.exercise.leetcode;

public class KthLargestElementinanArray {
    int ret = 0;
    public int findKthLargest(int[] nums, int k) {
        qSort(nums, 0, nums.length-1, nums.length-k);
        System.out.println(ret);
        return ret;
    }

    private void qSort(int[] nums, int lo, int hi, int k) {
        if (lo <= hi) {
            int pivot = partition(nums, lo, hi);
            if (pivot == k) {
                ret = nums[pivot];
                return;
            }
            if (pivot > k) {
                qSort(nums, lo, pivot-1, k);
            } else {
                qSort(nums, pivot+1, hi, k);
            }
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int tmp = nums[hi];
        int idx = lo;
        for(int i=lo; i<hi; i++) {
            if (nums[i] <= tmp) {
                swap(nums, i, idx++);
            }
        }
        swap(nums, idx, hi);
        return idx;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        new KthLargestElementinanArray().findKthLargest(nums, 4);
    }
}
