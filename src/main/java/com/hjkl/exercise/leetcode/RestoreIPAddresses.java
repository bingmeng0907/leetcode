package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        backtrack(s,list,new StringBuilder(),0,0);
        return list;
    }
    private void backtrack(String s, List<String> list, StringBuilder sb, int index, int level){
        if(index > s.length() || level > 4) return;
        else if(index == s.length() && level == 4){
            list.add(sb.toString());
            return;
        }
        for(int i = 1;i <= 3;i++){
            if(index+i > s.length()) break;
            int num = Integer.valueOf(s.substring(index,index+i));
            if((i == 1) || (i==2 && num >=10 && num <=99) || (i == 3 && num >= 100 && num <= 255)){
                sb.append(num);
                if(level < 3) sb.append(".");
                backtrack(s,list,sb,index+i,level+1);
                if(level < 3) sb.deleteCharAt(sb.length()-1);
                sb.delete(sb.length()-i,sb.length());
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = new RestoreIPAddresses().restoreIpAddresses(s);
        for(String l : list) {
            System.out.println(l);
        }
    }
}
