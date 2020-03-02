package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarrayswithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0, prefix = 0;
        int[] hash = new int[A.length + 1];
        for(int s=0,e=0,cnt=0;e<A.length;e++) {
            hash[A[e]]++;
            if(hash[A[e]] == 1) cnt++;
            if(cnt>K){
                hash[A[s]]--;
                s++;
                cnt--;
                prefix=0;
            }
            while(hash[A[s]]>1) {
                prefix++;
                hash[A[s]]--;
                s++;
            }
            if (cnt == K) res += prefix+1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,1,2,3};
        int K = 2;
        new SubarrayswithKDifferentIntegers().subarraysWithKDistinct(A, K);
    }
}
