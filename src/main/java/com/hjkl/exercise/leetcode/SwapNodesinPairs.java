package com.hjkl.exercise.leetcode;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode cur = dumy;
        while(cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
        }
        return dumy.next;
    }
}
