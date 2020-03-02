package com.hjkl.exercise.leetcode;

import java.util.*;

public class SmallestRangeCoveringElementsfromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.size(); i++) {
            pq.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int start=0, end=Integer.MAX_VALUE;
        while(pq.size() == nums.size()) {
            int[] e = pq.poll();
            int row = e[0], cln = e[1];
            if(end-start > max-nums.get(row).get(cln)) {
                end = max;
                start = nums.get(row).get(cln);
            }
            if (cln+1 < nums.get(row).size()) {
                pq.offer(new int[]{row, cln+1});
                max = Math.max(max, nums.get(row).get(cln+1));
            }
        }
        return new int[]{start, end};
    }
//    public int[] smallestRange(List<List<Integer>> nums) {
//        Map<Integer, Integer> map = new HashMap<>();// 当前窗口中，每个list包含多少个元素
//        List<Element> allList = new ArrayList<>();
//        for(int i=0; i<nums.size(); i++) {
//            for(int x : nums.get(i)) {
//                allList.add(new Element(x, i));
//            }
//        }
//        Collections.sort(allList, Comparator.comparingInt(o -> o.v));
//        int left=0, n=allList.size(), k=nums.size(), cnt=0, diff=Integer.MAX_VALUE;
//        int[] ret = new int[2];
//        for(int right=0;right<n; right++) {
//            Element ele = allList.get(right);
//            int val = ele.v;
//            int row = ele.r;
//            if (map.getOrDefault(row, 0) == 0) cnt++;
//            map.put(row, map.getOrDefault(row, 0)+1);
//            while(cnt == k && left<=right) {
//                if (diff > (allList.get(right).v-allList.get(left).v)) {
//                    diff = allList.get(right).v-allList.get(left).v;
//                    ret[0] = allList.get(left).v;
//                    ret[1] = allList.get(right).v;
//                }
//                map.put(allList.get(left).r, map.getOrDefault(allList.get(left).r, 0)-1);
//                if (map.getOrDefault(allList.get(left).r, 0) == 0) cnt--;
//                left++;
//            }
//        }
//        return ret;
//    }
}
class Element{
    int v;
    int r;
    Element(int v, int r) {
        this.v = v;
        this.r = r;
    }
}
