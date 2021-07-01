package com.hjkl.exercise.Filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class TestBloomFilter {
    public static void main(String[] args) {
        int total = 1000000;
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), total);
        for(int i=0; i<total; i++) {
            filter.put(i);
        }


//        for(int i=0; i<total; i++) {
//            if(!filter.mightContain(i)) {
//                System.out.println("xxxxxxxxxxx");
//            }
//        }


        int count = 0;
        for(int i=total; i<total+10000; i++) {
            if(filter.mightContain(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
