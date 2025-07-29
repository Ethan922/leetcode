package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    // 括号生成
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0);
        return ans;
    }

    public void backtracking(int n, int left, int right) {
        if (path.length() == n * 2) {
            ans.add(path.toString());
            return;
        }
        if (left < n) {
            path.append('(');
            backtracking(n, left + 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(')');
            backtracking(n, left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
