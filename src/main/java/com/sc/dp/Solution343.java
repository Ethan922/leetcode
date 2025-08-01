package com.sc.dp;

public class Solution343 {
    // 整数拆分
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i / 2; j++) {
                dp[i] = Math.max(Math.max(dp[i], j * dp[i - j]), j * (i - j));
            }
        }
        return dp[n];
    }
}
