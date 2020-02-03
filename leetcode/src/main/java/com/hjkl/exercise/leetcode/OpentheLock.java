package com.hjkl.exercise.leetcode;

import java.util.*;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visit = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        visit.add("0000");
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String s = queue.poll();
                if (target.equals(s)) return step;
                if (dead.contains(s)) continue;
                for(int j=0; j<4; j++) {
                    char ch = s.charAt(j);
                    String next = s.substring(0, j) + (ch == '9' ? 0 : ch-'0'+1) + s.substring(j+1);
                    String pre = s.substring(0, j) + (ch == '0' ? 9 : ch-'0'-1) + s.substring(j+1);
                    if (!visit.contains(next) && !dead.contains(next)) {
                        queue.offer(next);
                        visit.add(next);
                    }
                    if (!visit.contains(pre) && !dead.contains(pre)) {
                        queue.offer(pre);
                        visit.add(pre);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
