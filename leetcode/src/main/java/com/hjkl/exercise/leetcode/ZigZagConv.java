package com.hjkl.exercise.leetcode;

public class ZigZagConv {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 0 || numRows <= 0) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        char[] chs = s.toCharArray();
        int len = chs.length;
        for(int i=0; i<len;) {
            for(int asc=0; asc<numRows && i<len;asc++) {
                StringBuilder sb = sbs[asc];
                sb.append(chs[i++]);
            }
            for(int desc=numRows-2; desc>0 && i<len; desc--) {
                StringBuilder sb = sbs[desc];
                sb.append(chs[i++]);
            }
        }
        StringBuilder ret = new StringBuilder();
        for(StringBuilder sb : sbs) {
            ret.append(sb);
        }
        return ret.toString();
    }
}
