package com.sc.dp;

public class Solution392 {
    // 最长公共子序列
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
}

