package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 组合
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 0);
        return ans;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, startIndex + 1);
            path.remove(path.size() - 1);
        }
    }
}
