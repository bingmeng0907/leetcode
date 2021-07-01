package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Tmp {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        backtrack(res,s, 0,new ArrayList<String>());
        for(List<String> list : res) {
            ans.add(String.join(".", list));
        }
        return ans;
    }
    private void backtrack(List<List<String>> res, String s, int idx, List<String> tmp) {
        if(tmp.size() == 3) {
            String ss = s.substring(idx);
            int x = Integer.parseInt(ss);
            if(x >= 0 && x <= 255) {
                tmp.add(ss);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size()-1);
            }
        } else {
            for(int i=1; i<=3; i++) {
                if(idx+i > s.length()) break;
                String ss = s.substring(idx, idx+i);
                int x = Integer.parseInt(ss);
                if(x == 111) {
                    System.out.println();
                }
                if((i==1) || (i==2 && x >= 10 && x <= 99) || (i==3 && x >=100 && x<=255)) {
                    tmp.add(ss);
                    backtrack(res, s, idx+i, tmp);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Tmp().restoreIpAddresses("25525511135");
    }

}
