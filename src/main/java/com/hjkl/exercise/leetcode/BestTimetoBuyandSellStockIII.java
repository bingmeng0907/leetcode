package com.hjkl.exercise.leetcode;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        if (prices.length <= 2) {
            return Math.max(0, prices[1]-prices[0]);
        }
        int[] left = new int[prices.length];
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            min = Math.min(prices[i], min);
            maxProfit = Math.max(maxProfit, prices[i]-min);
            left[i] = maxProfit;
        }
        System.out.println(Arrays.toString(left));
        int[] right = new int[prices.length];
        maxProfit = Integer.MIN_VALUE;
        int max = prices[prices.length-1];
        for(int i=prices.length-1; i>=0; i--) {
            max = Math.max(prices[i],max);
            maxProfit = Math.max(maxProfit, max-prices[i]);
            right[i] = maxProfit;
        }
        System.out.println(Arrays.toString(right));
        int res = 0;
        for(int i=0; i<prices.length; i++) {
            res = Math.max(left[i]+right[i], res);
        }
        return res;
    }
}
