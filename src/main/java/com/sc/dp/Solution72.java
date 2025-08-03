package com.sc.dp;

public class Solution72 {
    // 编辑距离
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        // 使得[0,i-1]的word1的子串和[0,j-1]的word2子串相同的最少操作步数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // i-1和j-1的字符相同，无需操作
                if (chars1[i - 1] == chars2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                    // 不相同，删除i-1或删除j-1或在i-1,j-1基础上替换其中的一个字符
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 1);
            }
        }
        return dp[m][n];
    }
}

