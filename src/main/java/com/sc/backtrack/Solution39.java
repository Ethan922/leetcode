package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    // 组合总和
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, candidates.length, 0, 0);
        return ans;
    }

    public void backtracking(int[] nums, int targetSum, int n, int startIndex, int sum) {
        if (sum > targetSum) {
            return;
        }
        if (sum == targetSum) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < n; i++) {
            path.add(nums[i]);
            sum += nums[i];
            backtracking(nums, targetSum, n, i, sum);
            sum -= nums[i];
            path.remove(path.size() - 1);
        }
    }
}
