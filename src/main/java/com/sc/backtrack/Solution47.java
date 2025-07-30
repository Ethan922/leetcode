package com.sc.backtrack;

import java.util.*;

public class Solution47 {
    // 全排列II
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums, new HashSet<>(), nums.length);
        return ans;
    }

    private void backTracking(int[] nums, Set<Integer> set, int n) {
        if (path.size() == n) {
            ans.add(new ArrayList<>(path));
        }
        Set<Integer> useSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i) || useSet.contains(nums[i])) {
                continue;
            }
            useSet.add(nums[i]);
            set.add(i);
            path.add(nums[i]);
            backTracking(nums, set, n);
            path.remove(path.size() - 1);
            set.remove(i);
        }
    }
}
