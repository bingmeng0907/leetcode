package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class TwoArrSumTopk {

    class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> topK(int[] arr1, int[] arr2, int k) {
        PriorityQueue<Node> maxHeap =
                new PriorityQueue<>((n1,n2) -> ((arr1[n1.x]+arr2[n1.y]) - (arr1[n2.x]+arr2[n2.y])));
        int m = arr1.length, n = arr2.length;
        maxHeap.add(new Node(0,0));
        List<Integer> res = new ArrayList<>();
        int[][] direct = {{0,1}, {1,0}};
        while(res.size()< k) {
            Node cur = maxHeap.remove();
            res.add(arr1[cur.x]+arr2[cur.y]);
            for(int[] dir : direct) {
                int x = cur.x + dir[0];
                int y = cur.y + dir[1];
                if(x >= m || y >= n) continue;
                maxHeap.add(new Node(x,y));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {3,5,7,9,11};
        List<Integer> list = new TwoArrSumTopk().topK(arr1, arr2, 4);
        for(int l : list) {
            System.out.println(l);
        }
    }
}
