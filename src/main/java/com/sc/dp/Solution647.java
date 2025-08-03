package com.sc.dp;

public class Solution647 {
    // 回文子串

    public int countSubstringsDP(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        // [i,j]的子串是否为回文子串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        ans++;
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]){
                            ans++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }
        return count;
    }

    private int expand(String s, int i, int j) {
        int count = 0;
        char[] chars = s.toCharArray();
        while (i >= 0 && j < chars.length) {
            if (chars[i] == chars[j]) {
                count++;
                i--;
                j++;
            } else {
                break;
            }
        }
        return count;
    }
}
