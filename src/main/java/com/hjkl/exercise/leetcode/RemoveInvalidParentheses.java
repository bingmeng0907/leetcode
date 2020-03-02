package com.hjkl.exercise.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();
        q.offer(s);
        visit.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            String str = q.poll();
            if (isValid(str)) {
                ret.add(str);
                found = true;
            }
            if(found) continue;
            for(int i=0; i<str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
                String ns = str.substring(0,i) + str.substring(i+1);
                if (!visit.contains(ns)) {
                    q.offer(ns);
                    visit.add(ns);
                }
            }
        }
        return ret;
    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') cnt++;
            if (c == ')') {
                if (cnt == 0) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }

//    public List<String> removeInvalidParentheses(String s) {
//        List<String> ret = new ArrayList<>();
//        remove(s, ret, 0, 0, '(', ')');
//        return ret;
//    }
//
//    private void remove(String s, List<String> ret, int iStart, int jStart, char open, char close) {
//        int numOpen = 0, numClose = 0;
//        for(int i=iStart; i<s.length(); i++) {
//            if (s.charAt(i) == open) numOpen++;
//            if (s.charAt(i) == close) numClose++;
//            if (numClose > numOpen) {
//                for(int j=jStart; j<=i; j++) {
//                    if (s.charAt(j) == close && (j==jStart || s.charAt(j-1) != close)) {
//                        remove(s.substring(0,j)+s.substring(j+1), ret, i, j, open, close);
//                    }
//                }
//                return;
//            }
//        }
//        String reverseS = new StringBuilder(s).reverse().toString();
//        if (open == '(') {
//            remove(reverseS, ret, 0, 0, ')', '(');
//        } else {
//            ret.add(reverseS);
//        }
//    }
}
