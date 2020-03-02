package com.hjkl.exercise.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {
    public int maxPoints(int[][] points) {
        if (points == null || points.length <= 0) return 0;
        Map<String, Integer> map = new HashMap<>();
        int ret = 0;
        for(int i=0; i<points.length; i++) {
            int dup = 0, cnt = 0;
            for(int j=i+1; j<points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int d = gcd(x1-x2, y1-y2);
                if (d == 0) {
                    dup++;
                } else {
                    String key = (x1-x2)/d + "_" + (y1-y2)/d;
                    map.put(key, map.getOrDefault(key, 0)+1);
                    cnt = Math.max(cnt, map.getOrDefault(key, 0));
                }
            }
            ret = Math.max(ret, dup+cnt+1);
        }
        return ret;
//        int res = 0;
//        for(int i=0; i<points.length; i++) {
//            int dup = 1;
//            for(int j=i+1; j<points.length; j++) {
//               int x1 = points[i][0], y1 = points[i][1];
//               int x2 = points[j][0], y2 = points[j][1];
//               if (x1 == x2 && y1 == y2) {
//                   dup++;
//                   continue;
//               }
//               int cnt = 0;
//               for(int k=0; k<points.length; k++) {
//                  long x3 = points[k][0], y3 = points[k][1];
//                  if (x1*y2+x2*y3+x3*y1 - x1*y3-x2*y1-x3*y2 == 0) cnt++;
//               }
//               res = Math.max(res, cnt);
//            }
//            res = Math.max(res, dup);
//        }
//        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,65536},{65536,0}};
        new MaxPointsonaLine().maxPoints(points);
        int x = 65536 * 65536;
        System.out.println(x);
    }

}
