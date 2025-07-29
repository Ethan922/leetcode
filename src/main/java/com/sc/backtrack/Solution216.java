package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    // 组合总和III
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1, 0);
        return ans;
    }

    public void backtracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum) {
            return;
        }
        if (path.size() == k) {
            if (sum == targetSum){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(targetSum, k, i + 1, sum);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
