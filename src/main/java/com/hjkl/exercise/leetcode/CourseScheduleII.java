package com.hjkl.exercise.leetcode;

import java.util.*;

public class CourseScheduleII {


    public int[] findOrder(int n, int[][] pre) {
        int[] res = new int[n];
        // build graph and count in degree
        List<Integer>[] graph = new List[n];
        for(int i=0; i<graph.length; i++) graph[i] = new LinkedList<>();
        int[] degree = new int[n];
        for(int[] p : pre) {
            int s = p[1], e = p[0];
            degree[e]++;
            graph[s].add(e);
        }
        // find in degree is 0 node
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<degree.length; i++) {
            if(degree[i] == 0) q.add(i);
        }
        // topological sort
        int cnt = pre.length;
        int i= 0;
        while(!q.isEmpty()) {
            int s = q.poll();
            res[i++] = s;
            for(int e : graph[s]) {
                cnt--;
                degree[e]--;
                if(degree[e] == 0) q.add(e);
            }
        }
        return i == n ? res : new int[0];
    }
}
