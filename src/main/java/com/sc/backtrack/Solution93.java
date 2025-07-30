package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    // 复原IP地址
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backTracking(sb, 0, 0);
        return ans;
    }

    private void backTracking(StringBuilder s, int startIndex, int dotCount) {
        if (dotCount == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                ans.add(s.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s.insert(i + 1, '.');
                backTracking(s, i + 2, dotCount + 1);
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    private Boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
