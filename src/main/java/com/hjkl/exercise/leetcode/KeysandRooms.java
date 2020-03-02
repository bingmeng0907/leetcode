package com.hjkl.exercise.leetcode;

import com.sun.jndi.cosnaming.CNCtx;

import java.util.*;

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visit = new HashSet<>();
        int cntRoom = rooms.size();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visit.add(0);
        while(!queue.isEmpty()) {
            if (visit.size() == cntRoom) return true;
            int size = queue.size();
            while(size-- > 0) {
                int room = queue.poll();
                List<Integer> keys = rooms.get(room);
                for(int key : keys) {
                    if (!visit.contains(key)) {
                        queue.offer(key);
                        visit.add(key);
                    }
                }
            }
        }
        return visit.size() == cntRoom;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        List<Integer> r2 = new ArrayList<>();
        r2.add(2);
        List<Integer> r3 = new ArrayList<>();
        r3.add(3);
        List<Integer> r4 = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        new KeysandRooms().canVisitAllRooms(list);
    }
}
