package com.hjkl.exercise;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class MergeMulList {
    public ListNode mergeMulList(List<ListNode> lists) {
        if(lists == null || lists.size() <= 0) return null;
        int size = lists.size();
        for(int step = 1; step < size; step *= 2) { // 1 2 4 8
            for(int i=0; i<size; i += 2*step) {
                // i=0,step=1 0,1
                // i=2,step=1 2,3
                // i=4,step=1 4,5
                // i=6,step=1 6,7
                if(i + step >= size) break;
                ListNode l1 = lists.get(i);
                ListNode l2 = lists.get(i+step);
                ListNode m = mergeList(l1, l2);
                lists.set(i, m);
            }
        }
        return lists.get(0);
    }
    private ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode dump = new ListNode(0);
        ListNode tmp = dump;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ListNode t = new ListNode(l1.val);
                tmp.next = t;
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                ListNode t = new ListNode(l2.val);
                tmp.next = t;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            tmp.next = l1;
        }
        if(l2 != null) {
            tmp.next = l2;
        }
        return dump.next;
    }
}
