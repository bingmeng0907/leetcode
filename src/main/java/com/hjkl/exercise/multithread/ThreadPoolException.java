package com.hjkl.exercise.multithread;

import java.util.concurrent.*;

public class ThreadPoolException {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
        for(int i=0; i<5; i++) {
            threadPool.submit(() -> {
                try {
                    System.out.println("current thread name" + Thread.currentThread().getName());
                    Object object = null;
                    System.out.print("result## "+object.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
