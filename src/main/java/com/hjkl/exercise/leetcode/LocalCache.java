package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;


interface Cache {
    String get(String key);
    void put(String key, String value);
}

public class LocalCache implements Cache{
    private int cacheSize;
    private ArrayDeque<String> queue = null;
    private Map<String, String> map = null;
    public LocalCache(int cacheSize) {
        if (cacheSize <= 0) {
            cacheSize = 1024;
        }
        this.cacheSize = cacheSize;
        queue = new ArrayDeque<>(cacheSize);
        map = new HashMap<>(cacheSize);
    }
    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public void put(String key, String value) {
        if (queue.size() == cacheSize) {
            synchronized (LocalCache.class) {
                String head = queue.poll();
                map.remove(head);
            }
        }
        synchronized (LocalCache.class) {
            queue.offer(key);
            map.put(key, value);
        }
    }
    /*
    We have a system needs a cache layer on it. How could you design a simple cache service? 
    [Expectation] 
    a) should be thread safe.
     b) should think about high throughput 
    c) should be flexible to change the cache implementation.
     d) should be flexible to change the type of cache key and cache value.
     e) should be easy to use. 
     */
    public static void main(String[] args) {
        LocalCache cache = new LocalCache(100000);
        for(int i=0; i<10000; i++) {
            cache.put(i+"", i+"——"+i);
        }
        for(int i=0; i<5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 10;
                    while(count-- > 0) {
                        String value = cache.get(count + "");
                        if (value == null) {
                            cache.put(count+"", count+"——"+"count");
                        }
                        System.out.println(cache.get(count+""));
                    }
                }
            });
            thread.start();
        }

    }
}
