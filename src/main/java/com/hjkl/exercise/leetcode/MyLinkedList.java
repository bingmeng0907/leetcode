package com.hjkl.exercise.leetcode;

import java.util.LinkedList;

public class MyLinkedList {
    private LinkedList<Integer> list;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        list = new LinkedList<>();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < list.size()) {
            return list.get(index);
        } else {
            return -1;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        list.addFirst(val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        list.addLast(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < list.size()) list.add(index, val);
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < list.size()) list.remove(index);
    }
}
