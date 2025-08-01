package com.sc.dp;

public class Solution416 {
    // 分割等和子集
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < target + 1; i++) {
            if (nums[0] <= i) {
                dp[0][i] = nums[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target] == target;
    }
}
