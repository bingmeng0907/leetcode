package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidIpCount {
    // {0-255}.{0-255}.{0-255}.{0-255}
    //1 2 3 4 5
    /*
     */
    public int solution(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return 0;
        int ret = 0;
        for (int i = 1; i <= s.length() - 3; i++) {
            int n1 = Integer.parseInt(s.substring(0, i));
            if (n1 >= 0 && n1 <= 255) {
                for (int j = i + 1; j <= s.length() - 2; j++) {
                    int n2 = Integer.parseInt(s.substring(i, j));
                    if (n2 >= 0 && n2 <= 255) {
                        for (int k = j + 1; k <= s.length() - 1; k++) {
                            int n3 = Integer.parseInt(s.substring(j, k));
                            int n4 = Integer.parseInt(s.substring(k, s.length()));
                            if (n3 >= 0 && n3 <= 255 && n4 >= 0 && n4 <= 255) {
                                System.out.println(n1 + "." + n2 + "." + n3 + "." + n4);
                                ret++;
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    private int ret;

    public int solution2(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return 0;
        recursive(s, 0, 4);
        System.out.println(ret);
        return ret;
    }

    private void recursive(String s, int idx, int count) {
        if (idx >= s.length()) return;
        if (count == 1) {
            int fourPart = Integer.parseInt(s.substring(idx));
            if (fourPart >= 0 && fourPart <= 255){
                ret++;
            }
            return;
        }
        for (int i = idx + 1; i <= idx + 3 && idx+i<=s.length(); i++) {
            int num = Integer.parseInt(s.substring(idx, i));
            if (num >= 0 && num <= 255) {
                recursive(s, i, count-1);
            }
        }
    }


    public static void main(String[] args) {
        String s = "12345";
//        s = "0123";
//        s = "01234543";
//        s = "012345678912";
        new ValidIpCount().solution2(s);
    }
}
