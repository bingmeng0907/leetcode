package com.hjkl.exercise.leetcode;

public class MajorityChecker {
    private int[] arr;
    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        int count = 0;
        int cand = -1;
        for(int i=left; i<=right; i++) {
            if (count == 0) {
                cand = arr[i];
                count++;
            }else {
                if (arr[i] == cand) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        for(int i=left; i<=right; i++) {
            if (cand == arr[i]) threshold--;
        }
        if (threshold <= 0) {
            return cand;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,1,1};
        MajorityChecker mc = new MajorityChecker(arr);
        mc.query(0,5,4);
    }
}
