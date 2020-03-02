package com.hjkl.exercise.leetcode;

public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.trim().length() <= 0) return false;
        s = s.trim();
        boolean dSeen = false;
        boolean eSeen = false;
        boolean numBeforeE = false;
        boolean numAfterE = false;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (!eSeen) numBeforeE = true;
                if (eSeen) numAfterE = true;
            }else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i-1) != 'e') return false;
            } else if (c == '.') {
                if (dSeen || eSeen) return false;
                dSeen = true;
            } else if (c == 'e') {
                if (eSeen) return false;
                eSeen = true;
            } else {
                return false;
            }
        }
        return eSeen ? (numBeforeE && numAfterE):numBeforeE;
    }
}
