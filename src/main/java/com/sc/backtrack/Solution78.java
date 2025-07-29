package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    // 子集
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    public void backtracking(int[] nums, int startIndex) {
        ans.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
