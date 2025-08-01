package com.sc.dp;

public class Solution474 {
    // 一和零
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int x = 0, y = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    x++;
                } else {
                    y++;
                }
            }
            for (int j = m; j >= x; j--) {
                for (int k = n; k >= y; k--) {
                    dp[j][k] = Math.max(dp[j - x][k - y] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
}
