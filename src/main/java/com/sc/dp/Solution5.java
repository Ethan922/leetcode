package com.sc.dp;

public class Solution5 {
    // 最长回文子串
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
