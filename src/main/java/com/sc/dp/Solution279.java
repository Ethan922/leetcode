package com.sc.dp;

import java.util.Arrays;

public class Solution279 {
    // 完全平方数
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i < n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Solution279().numSquares(1);
    }
}
