package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class Joseph {
    public int joseph(int n, int m) {
        if (n <= 1 || m<= 1) return -1;
        int ans;
        if(m % 2 == 0) {
            ans = 0;
        } else {
            ans = 1;
        }
        for(int i=3 ;i<=n; i++) {
            ans = (ans + m) % i;
        }
        return ans + 1;
    }


    public int recur(int n, int m) {
        if(n <= 1 || m <= 1) return -1;
        if(n <= 2) {
            if(m % 2 == 0) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return (recur(n-1, m) + m) % n;
        }
    }

    public int arr(int n, int m) {
        if(n <= 1 || m <= 1) return -1;
        if(n <= 2) {
            if(m % 2 == 0) {
                return 1;
            } else {
                return 2;
            }
        }
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int count = 0;
        int num = 0;
        while( count < n-1) {
            for(int i=0; i<arr.length; i++) {
                if(arr[i] == 1) {
                    num++;
                    if(num == m) {
                        arr[i] = 0;
                        count++;
                        num = 0;
                    }
                    if(count == n-1) break;
                }
            }
        }
        int r = 0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                r = i;
                break;
            }
        }
        return r+1;
    }
    public int f(int n, int m) {
        return n == 1 ? n : (f(n-1, m)+m-1) % n+1;
    }

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        System.out.println(joseph.joseph(10,3));
        System.out.println(joseph.f(10,3));
        System.out.println(joseph.recur(10, 3));
        System.out.println(joseph.arr(10, 3));
    }
}
