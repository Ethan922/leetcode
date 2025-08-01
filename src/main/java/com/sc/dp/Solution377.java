package com.sc.dp;

public class Solution377 {
    // 组合总和IV
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[i]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
