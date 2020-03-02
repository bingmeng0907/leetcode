package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null) return "";
        List<String> ret = new ArrayList<>();
        s = s.trim();
        String[] arrs = s.split("\\s+");
        List<String> list = Arrays.asList(arrs);
        StringBuilder sb = new StringBuilder();
        for(int i = list.size()-1; i>=0; i--) {
            sb.append(list.get(i) + " ");
        }
        return sb.toString().trim();
    }
}
