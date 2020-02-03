package com.hjkl.exercise.leetcode;

import java.util.*;



public class TopKFrequentElements {
    class Node{
        int key;
        int value;
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }

    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Node> list = new ArrayList<>();
        for(int key : map.keySet()) {
            list.add(new Node(key, map.get(key)));
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<k; i++) {
            ret.add(list.get(i).key);
        }
        return ret;
    }
}
