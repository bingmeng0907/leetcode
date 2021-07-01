package com.hjkl.exercise.multithread;

import javax.tools.DiagnosticCollector;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class TestThread implements Runnable{
    private static ThreadLocal<String> tls = new ThreadLocal<>();
    @Override
    public void run() {
        tls.set("leetcode.com");
        //System.out.println(tls.get());
        f1();
        f2();
        tls.remove();
    }
    private void f1() {
        System.out.println(tls.get());
    }
    private void f2() {
        System.out.println(tls.get());
    }
}
public class TestThreadLocal {
    public static void main(String[] args) {
        new Thread(new TestThread()).start();
    }
}
