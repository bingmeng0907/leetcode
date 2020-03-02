package com.hjkl.exercise.leetcode;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length,n = nums2.length;
        int l1=0,l2=0,r1=0,r2=0,c1,c2;
        int low = 0, high = 2*m;
        while(low<=high) {
            c1 = (low+high)/2;
            c2 = m+n-c1;
            l1 = (c1 == 0 ? Integer.MIN_VALUE : nums1[(c1-1)/2]);
            r1 = (c1 == 2*m ? Integer.MAX_VALUE : nums1[c1/2]);
            l2 = (c2 == 0 ? Integer.MIN_VALUE : nums2[(c2-1)/2]);
            r2 = (c2 == 2*n ? Integer.MAX_VALUE : nums2[c2/2]);
            if (l1 > r2) {
                high = c1 -1;
            } else if (l2 > r1) {
                low = c1 + 1;
            } else {
                break;
            }
        }
        return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
    }
}
