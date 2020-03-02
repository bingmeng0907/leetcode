package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 0) return 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        // 从左往右遍历，碰到比栈顶元素高的入栈，比栈顶低的出栈计算面积,直到栈空或者高度比栈顶元素高度高
        for(int i=0; i<= heights.length;) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int tp = stack.pop();
                int area = heights[tp] * (stack.isEmpty() ? i : i - stack.peek() -1);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
