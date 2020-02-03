package com.hjkl.exercise.leetcode;

public class MyCircularQueue {

    private int[] arr;
    private int front,rear;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear++;
        rear = rear%arr.length;
        arr[rear] = value;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        arr[front] = -1;
        front++;
        front = front%arr.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(8);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.deQueue();
        obj.deQueue();
        obj.isEmpty();
        obj.isEmpty();
        obj.Rear();
        obj.Rear();
        obj.isFull();
    }
}
