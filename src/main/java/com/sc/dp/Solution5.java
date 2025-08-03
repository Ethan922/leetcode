package com.sc.dp;

public class Solution5 {
    // 最长回文子串
    public String longestPalindromeDP(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        if (j - i + 1 > max) {
                            max = j - i + 1;
                            ans = s.substring(i, j + 1);
                        }
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            if (j - i + 1 > max) {
                                max = j - i + 1;
                                ans = s.substring(i, j + 1);
                            }
                        }
                    }

                }
            }
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int n = s.length();
        int maxLen = 1;
        String ans = "";
        for (int i = 0; i < n - 1; i++) {
            String s1 = expand(s, i, i + 1);
            if (s1.length() > maxLen) {
                ans = s1;
                maxLen = s1.length();
            }
            String s2 = expand(s, i, i);
            if (s2.length() > maxLen) {
                ans = s2;
                maxLen = s2.length();
            }
        }
        return ans;
    }

    private String expand(String s, int i, int j) {
        char[] chars = s.toCharArray();
        while (i >= 0 && j < chars.length) {
            if (chars[i] == chars[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
