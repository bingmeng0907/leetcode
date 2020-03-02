package com.hjkl.exercise.leetcode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode p = dumy, q = dumy;
        for(; p != null; p = p.next, n--) {
            if (n < 0) {
                q = q.next;
            }
        }
        q.next = q.next.next;
        return dumy.next;
    }
}
