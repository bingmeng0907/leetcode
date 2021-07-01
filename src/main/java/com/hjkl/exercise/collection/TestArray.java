package com.hjkl.exercise.collection;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        String[] arr = new String[5];
        for(int i=0; i<arr.length; i++) arr[i] = i+"";
        //System.arraycopy(arr, 0, arr, 1, 4);
        Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(arr));
    }
}
