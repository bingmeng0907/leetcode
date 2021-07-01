package com.hjkl.exercise;

import java.util.ArrayDeque;

public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if( c == '[' || c == '(') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;
                char p = stk.pop();
                switch (c) {
                    case ']':
                        if (p != '[') return false;
                        break;
                    case ')':
                        if (p != '(') return false;
                        break;
                }
            }
        }
        return stk.isEmpty();
    }

    public int maxConSum(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int sum = 0;
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            if(sum + arr[i] >= 0) {
                sum += arr[i];
            } else {
                if(sum+arr[i] > arr[i]) {
                    sum += arr[i];
                } else {
                    sum = 0;
                }
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
//        String s = "()";
//        s = "(";
//        s = "([])";
//        s = "[(";
//        s = "([]";
//        s = "";
//        s = "(((([[[]]]]";
//        System.out.println(new Solution().isValid(s));
        int[] arr = {-2,2,3};
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = {1,2,-3,2,3};
        Solution s = new Solution();
        System.out.println(s.maxConSum(arr));
        System.out.println(s.maxConSum(arr2));
        System.out.println(s.maxConSum(arr3));
    }
}
