package com.sc.dp;

public class Solution392 {
    // 判断子序列
    public boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        if (m == 0) return true;
        if (n < m) {
            return false;
        }
        int j = 0;
        for (char c : chars2) {
            if (c == chars1[j]) {
                j++;
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubsequenceDP(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int m = sChars.length;
        int n = tChars.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (sChars[i - 1] == tChars[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[m][n] == m;
    }
}

