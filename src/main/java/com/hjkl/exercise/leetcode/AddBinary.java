package com.hjkl.exercise.leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        /*
        Input: a = "1010", b = "1011"
        Output: "10101"
        1010
        1011
       10101
         */
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int i=as.length-1, j=bs.length-1;
        while(i>=0 || j>=0) {
            int ac = 0;
            if (i>=0) {
                ac = as[i]-'0';
            }
            int bc = 0;
            if (j>=0) {
                bc = bs[j]-'0';
            }
            int rc = ac+bc+carry;
            sb.append(rc%2);
            carry = rc/2;
            i--;
            j--;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        new AddBinary().addBinary(a,b);
    }
}
