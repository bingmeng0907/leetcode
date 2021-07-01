package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindRepeatCharFrom2Str {
    public static List<Character> findRepeatChar(String s1, String s2){
        List<Character> list = new ArrayList<>();
        if(s1 == null || s2 == null) return list;
        int a = 0;
        for(int i=0; i<s1.length(); i++) {
            a |= (1 << (s1.charAt(i) - 'a'));
        }
        int b = 0;
        for(int i=0; i<s2.length(); i++) {
            b |= (1 << (s2.charAt(i) - 'a'));
        }
        int c = a & b;
        String cs = Integer.toBinaryString(c);
        for(int i=0; i<cs.length(); i++) {
            if(cs.charAt(i) == '1') {
                list.add((char)('a' + i+1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bcd";
        List<Character> list = FindRepeatCharFrom2Str.findRepeatChar(s1, s2);
        for(char c : list) {
            System.out.println(c);
        }
    }
}
