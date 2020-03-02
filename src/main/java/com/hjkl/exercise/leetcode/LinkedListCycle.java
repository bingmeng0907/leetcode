package com.hjkl.exercise.leetcode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p = head, q = head;
        while(p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) return true;
        }
        return false;
    }
}
