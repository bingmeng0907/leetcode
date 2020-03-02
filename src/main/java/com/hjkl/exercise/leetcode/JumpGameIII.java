package com.hjkl.exercise.leetcode;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visit = new boolean[arr.length];
        return recursive(arr, start, visit);
    }

    public boolean recursive(int[] arr, int start, boolean[] visit) {
        if (start < 0 || start >= arr.length) return false;
        if (visit[start]) return false;
        if (arr[start] == 0) return true;
        visit[start] = true;
        return recursive(arr, start-arr[start], visit) || recursive(arr, start+arr[start], visit);
    }

    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};
        int start = 2;
        boolean b = new JumpGameIII().canReach(arr, start);
        System.out.println(b);
    }
}
