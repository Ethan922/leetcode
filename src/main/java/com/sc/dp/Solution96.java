package com.sc.dp;

public class Solution96 {
    // 不同的二叉搜索树
    public int numTrees(int n) {
        if (n == 2) {
            return 2;
        }
        // dp[i],n=i时的二叉搜索树的种类数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
