package com.sc.dp;

public class Solution647 {
    // 回文子串
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
