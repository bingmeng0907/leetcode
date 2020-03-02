package com.hjkl.exercise.leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dumy = new ListNode(0);
        ListNode ret = dumy;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dumy.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                dumy.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            dumy = dumy.next;
        }
        if (l1 != null) {
            dumy.next = l2;
        }
        if (l2 != null) {
            dumy.next = l1;
        }
        return ret.next;
    }
}
