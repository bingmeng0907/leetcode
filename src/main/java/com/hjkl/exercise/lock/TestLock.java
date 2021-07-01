package com.hjkl.exercise.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    // 悲观锁的调用方式：synchronized,lock
    //synchronized
    public synchronized void exec(){
        // 操作同步资源
    }

    // lock
    private ReentrantLock lock = new ReentrantLock();// 确保多个线程使用同一个锁
    public void exec2() {
        lock.lock();
        // 操作同步资源
        lock.unlock();
    }

    // 乐观锁的调用方式
    private AtomicInteger atomicInteger = new AtomicInteger(); // 确保多个线程操作同一个对象
    private void exec3() {
        atomicInteger.incrementAndGet();
    }
}
