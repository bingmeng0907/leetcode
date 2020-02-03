package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;

public class PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        if (root == null) return root;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            Node next;
            while(size-- > 0) {
                next = queue.poll();
                if (next.left != null) queue.offer(next.left);
                if (next.right != null) queue.offer(next.right);
                if (pre != null) {
                    pre.next = next;
                }
                pre = next;
            }
            pre.next = null;
        }
        return root;
    }
}
