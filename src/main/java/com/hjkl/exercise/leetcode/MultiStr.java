package com.hjkl.exercise.leetcode;

public class MultiStr {

    private String pow(int n) {
        if(n == 0) return "1";
        if(n == 1) return "11";
        String tmp = pow(n/2);
        if(n % 2 == 0) {
            return strMulti(tmp,tmp);
        } else {
            return strMulti(strMulti(tmp, tmp), "11");
        }
    }

    private String strMulti(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] arr = new int[m+n];
        for(int i=s.length()-1; i>=0; i--){
            for(int j=t.length()-1; j>=0; j--){
                int back = i+j+1;
                int front =back-1;
                int mul = (s.charAt(i)-'0') * (t.charAt(j)-'0');
                int sum = arr[back] + mul;
                arr[back] = sum % 10;
                arr[front] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(sb.length() == 0 && arr[i] == 0) continue;
            else sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "123";
        String t = "456";
        System.out.println(new MultiStr().strMulti(s,t));
        System.out.println(new MultiStr().pow(3));
    }

}
