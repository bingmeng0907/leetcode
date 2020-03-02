package com.hjkl.exercise.leetcode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dumy = new ListNode(-1);
        while(head != null) {
            ListNode next = head.next;
            head.next = dumy.next;
            dumy.next = head;
            head = next;
        }
        return dumy.next;
    }
}
