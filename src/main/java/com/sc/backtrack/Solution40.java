package com.sc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    // 组合总和II
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        Arrays.fill(used, false);
        backtracking(candidates, target, candidates.length, 0, 0, used);
        return ans;
    }

    public void backtracking(int[] nums, int targetSum, int n, int startIndex, int sum, boolean[] used) {
        if (sum > targetSum) {
            return;
        }
        if (sum == targetSum) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            sum += nums[i];
            backtracking(nums, targetSum, n, i + 1, sum, used);
            sum -= nums[i];
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
