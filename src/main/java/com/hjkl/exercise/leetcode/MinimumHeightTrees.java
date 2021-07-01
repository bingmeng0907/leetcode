package com.hjkl.exercise.leetcode;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(edges == null || edges.length <= 0) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new LinkedList<>());
        }
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            graph.get(s).add(e);
            degree[s]++;
            graph.get(e).add(s);
            degree[e]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<degree.length; i++) {
            if(degree[i] == 1) q.add(i);
        }

        while(!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            while(size-- > 0) {
                int x = q.poll();
                res.add(x);
                for(int y : graph.get(x)) {
                    degree[y]--;
                    if(degree[y] == 1) q.add(y);
                }
            }
        }
        return res;
    }

    /*
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new LinkedList<>());
        }
        buildGraph(graph, edges);
        int minH = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int h = getMinHeight(i, graph);
            if (h < minH) {
                minH = h;
                res.clear();
                res.add(i);
            } else if (h == minH) {
                res.add(i);
            } else {
                continue;
            }
        }

        return res;
    }

    private int getMinHeight(int i, Map<Integer, List<Integer>> graph) {
        Set<Integer> set = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(i);
        set.add(i);
        int h = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                List<Integer> list = graph.get(q.poll());
                for(int l : list) {
                    if(set.contains(l)) continue;
                    q.add(l);
                    set.add(l);
                }
            }
            h++;
        }
        return h-1;
    }

    private void buildGraph(Map<Integer, List<Integer>> graph, int[][] edges) {
        for(int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
    }
    */
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        List<Integer> list = new MinimumHeightTrees().findMinHeightTrees(n, edges);
        System.out.println(Arrays.toString(list.toArray()));
    }

}
