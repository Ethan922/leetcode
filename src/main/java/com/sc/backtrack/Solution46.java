package com.sc.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution46 {
    // 全排列
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        backtracking(set, nums.length);
        return ans;
    }

    public void backtracking(Set<Integer> nums, int n) {
        if (nums.size() + path.size() < n) {
            return;
        }
        if (path.size() == n) {
            ans.add(new ArrayList<>(path));
        }
        for (Integer num : nums) {
            path.add(num);
            Set<Integer> newSet = new HashSet<>(nums);
            newSet.remove(num);
            backtracking(newSet, n);
            path.remove(path.size() - 1);
        }
    }
}
