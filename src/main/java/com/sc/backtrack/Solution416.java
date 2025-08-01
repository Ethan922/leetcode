package com.sc.backtrack;

public class Solution416 {
    // 分割等和子集
    int path = 0;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return backtracking(nums, 0, sum / 2);
    }

    private boolean backtracking(int[] nums, int startIndex, int targetSum) {
        if (path == targetSum) {
            return true;
        } else if (path > targetSum) {
            return false;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > targetSum) {
                continue;
            }
            path += nums[i];
            boolean flag = backtracking(nums, i + 1, targetSum);
            if (flag) {
                return true;
            }
            path -= nums[i];
        }
        return false;
    }
}
