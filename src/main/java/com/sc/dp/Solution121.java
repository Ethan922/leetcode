package com.sc.dp;

public class Solution121 {
    // 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 持有
        dp[0][0] = -prices[0];
        // 不持有
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 持有
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 不持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}

