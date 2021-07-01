package com.hjkl.exercise.leetcode;

public class BinarySearch {
    public int searchIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public int searchLeftIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == nums.length || nums[left] != target) return -1;
        return left;
    }

    public int searchRightIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.searchIndex(arr, 0));
        System.out.println(bs.searchIndex(arr, 3));
        System.out.println(bs.searchIndex(arr, 11));
        System.out.println("-------------");
        int[] arr2 = {1, 2, 2, 2, 3, 4};
        System.out.println(bs.searchLeftIndex(arr2, 2));
        System.out.println("-------------");
        System.out.println(bs.searchRightIndex(arr2, 2));
    }
}
