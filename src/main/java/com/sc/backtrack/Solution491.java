package com.sc.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution491 {
    // 非递减子序列
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return ans;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (set.contains(nums[i]) || (!path.isEmpty() && nums[i] < path.get(path.size() - 1))) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
