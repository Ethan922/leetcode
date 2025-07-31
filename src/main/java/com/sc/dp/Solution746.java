package com.sc.dp;

public class Solution746 {
    // 使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int pre = 0;
        int cur = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int temp = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
