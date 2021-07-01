package com.hjkl.exercise.leetcode;

import java.util.concurrent.Semaphore;

class MyThread implements Runnable{
    Semaphore next;
    Semaphore cur;
    static int start = 0;
    int end = 10;
    public MyThread(Semaphore next, Semaphore cur) {
        this.next = next;
        this.cur = cur;
    }

    @Override
    public void run() {
        while(start < end) {
            try {
                cur.acquire();
                System.out.println(start++ + "\t" + Thread.currentThread().getName());
                if (start < end) next.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test {

    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        Thread t1 = new Thread(new MyThread(s2, s1), "thread-1");
        Thread t2 = new Thread(new MyThread(s3, s2), "thread-2");
        Thread t3 = new Thread(new MyThread(s1, s3), "thread-3");
        t1.start();
        t2.start();
        t3.start();
    }

}
